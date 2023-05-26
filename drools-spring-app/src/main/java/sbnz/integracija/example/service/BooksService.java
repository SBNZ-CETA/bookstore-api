package sbnz.integracija.example.service;

import demo.facts.Book;
import demo.facts.BookCategory;
import demo.facts.RateUnit;
import demo.facts.Rating;
import demo.facts.UnauthorizedRecommendedBooks;
import demo.facts.User;
import dtos.BookDto;
import dtos.RatingDto;
import lombok.AllArgsConstructor;

import org.dmg.pmml.Model;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.dto.BookReviewDto;
import sbnz.integracija.example.repository.BooksRepository;
import sbnz.integracija.example.repository.RatingRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.utils.UserUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BooksService {
   private final BooksRepository booksRepository;
   private final UserRepository userRepository;
   private final RatingRepository ratingRepository;
   private final UserUtils userUtils;
   private final ModelMapper modelMapper;
   private final KieContainer kieContainer;

   public List<BookDto> getAllBookDtos() {
        List<Book> books = booksRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        books.stream().forEach(book -> { 
            Set<Rating> ratings = book.getRatings();
            Set<RatingDto> ratingsDto = new HashSet<>();
            ratings.stream().forEach(rating -> {
                ratingsDto.add(new RatingDto(rating.getId(),rating.getBook().getId(),rating.getRate()));
            });
            BookDto dto = new BookDto(book);
            dto.setRatings(ratingsDto);
            booksDto.add(dto);
         });
       return booksDto;
   }

   public List<Book> getAll() {
    return booksRepository.findAll();
    }


   public Book getById(Long id) {
       return booksRepository.findById(id).orElse(null);
   }
   public Book create(BookCreateDto newBook) {
       Book book = modelMapper.map(newBook, Book.class);
       book.setPublishDate(LocalDateTime.now());
       book.setReleaseDate(LocalDateTime.now());
       book.setRateUnit(RateUnit.NEUTRAL);
       return booksRepository.save(book);
   }

    public Rating review(BookReviewDto reviewDto) {
       if (reviewDto.getRate() > 5 || reviewDto.getRate() < 1){
            return null;
       }

       Book book = booksRepository.getOne(reviewDto.getBookId());
       Long userId = userUtils.getLoggedId();
       User user = userRepository.getOne(userId);
       Rating rating = new Rating(book.getId(),user.getId(),reviewDto.getRate());

       rating = ratingRepository.save(rating);
    
       book = rateBook(book);
       booksRepository.save(book);
       return rating;
    }

    private Book rateBook(Book book){
        List<Rating> ratings= ratingRepository.FindAllByBookId(book.getId()).orNull();
        int ratingCount=0;
        double totalRating=0;
        
        for(Rating rate:ratings){
            ratingCount++;
            totalRating+=rate.getRate();
        }
        totalRating = totalRating/ratingCount;
        
        book.setRateCount(ratingCount);
        book.setRating(totalRating);
        return book;
    }

    public List<Book> getRecommendedUnauthorized() {
        KieSession kieSession = kieContainer.newKieSession();
        List<Book> books = getAll();
        for (Book book: books) {
            kieSession.insert(book);
        }
        UnauthorizedRecommendedBooks unauthorizedRecommendedBooks = new UnauthorizedRecommendedBooks();
        kieSession.insert(unauthorizedRecommendedBooks);

        kieSession.getAgenda().getAgendaGroup("newBook").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("popularBook").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("bookRate").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("recommendBook").setFocus();
        kieSession.fireAllRules();
//        kieSession.getAgenda().getAgendaGroup("filterBooks").setFocus();
//        kieSession.fireAllRules();
        kieSession.dispose();
        return unauthorizedRecommendedBooks.getBooks();
    }

    public List<BookCategory> getAllBookCategories() {
        return Arrays.asList(BookCategory.values());
    }

    public List<Book> getReccommendedAuthorized() {
        Long userId = userUtils.getLoggedId();
        User user = userRepository.getOne(userId);

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(user);
        
        kieSession.getAgenda().getAgendaGroup("userState").setFocus();
    
        return null;
    }
}
