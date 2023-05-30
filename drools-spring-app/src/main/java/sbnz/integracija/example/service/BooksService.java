package sbnz.integracija.example.service;

import demo.facts.Book;
import demo.facts.BookCategory;
import demo.facts.Genre;
import demo.facts.RateUnit;
import demo.facts.Rating;
import demo.facts.UnauthorizedRecommendedBooks;
import demo.facts.User;
import demo.facts.UserState;
import dtos.*;
import lombok.AllArgsConstructor;

import org.dmg.pmml.Model;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.repository.BooksRepository;
import sbnz.integracija.example.repository.GenreRepository;
import sbnz.integracija.example.repository.RatingRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.utils.UserUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BooksService {
   private final BooksRepository booksRepository;
   private final UserRepository userRepository;
   private final RatingRepository ratingRepository;
   private final GenreRepository genreRepository;
   private final RatingsService ratingsService;
   private final UserUtils userUtils;
   private final ModelMapper modelMapper;
   private final KieContainer kieContainer;

   public List<BookDto> getAllBookDtos() {
        List<Book> books = getAll();
       return booksTobooksDto(books);
   }

    private List<Book> getAll() {
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
    
       book = ratingsService.rateBook(book);
       booksRepository.save(book);
       return rating;
    }

    public List<BookDto> getRecommendedUnauthorized() {
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
        kieSession.dispose();
        return booksTobooksDto(unauthorizedRecommendedBooks.getBooks());
    }

    public List<Genre> getAllBookGenres() {
        return genreRepository.findAll();
    }

    public List<BookDto> getReccommendedAuthorized() {
        System.out.println("INSIDE AUTHROIZED RECCOMMEND");
        Long userId = userUtils.getLoggedId();
        User user = userRepository.getOne(userId);
        UnauthorizedRecommendedBooks unauthorizedRecommendedBooks = new UnauthorizedRecommendedBooks();
        System.out.println(user.getFavoriteGenres());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(user);
        kieSession.insert(this.getAllOtherUserRatings(user.getUsername()));

        System.out.println("RUN KIE SESSION");

        kieSession.getAgenda().getAgendaGroup("userState").setFocus();
        kieSession.getAgenda().getAgendaGroup("oldUser").setFocus();
        kieSession.fireAllRules();

        if(user.getState()==UserState.NEW) return getRecommendedUnauthorized();
        if(user.getState()==UserState.NEW_WITH_GENRES){
            Set<Genre> favoriteGenres = user.getFavoriteGenres();
            favoriteGenres.stream().forEach(genre->{
                kieSession.insert(genre);
            });
            // LEE PRAVILA
            // kieSession.getAgenda().getAgendaGroup("userState").setFocus();
            // kieSession.fireAllRules();
        }
        if(user.getState()==UserState.OLD){
            // COFI PRAVILA
            // kieSession.getAgenda().getAgendaGroup("userState").setFocus();
            // kieSession.fireAllRules();
        }
        Collection<Book> books = (Collection<Book>)kieSession.getObjects(new ClassObjectFilter(Book.class));
        kieSession.dispose();
        return booksTobooksDto(books.stream().collect(Collectors.toList()));
    }


    private List<BookDto> booksTobooksDto(List<Book> books) {
        List<BookDto> booksDto = new ArrayList<>();
            books.stream().forEach(book -> { 
                BookDto dto = new BookDto(book);
                booksDto.add(dto);
            });
        return booksDto;
    }

    public List<UserRatingsDto> getAllOtherUserRatings(String username) {
        return userRepository
                .findAll()
                .stream()
                .filter(user -> !user.getUsername().equals(username))
                .map(user -> new UserRatingsDto(user.getRatings()))
                .collect(Collectors.toList());
    }
}


