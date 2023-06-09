package sbnz.integracija.example.service;

import demo.facts.AuthorizedRecommendedFavoriteGenreBooks;
import demo.facts.Book;
import demo.facts.Genre;
import demo.facts.RateUnit;
import demo.facts.Rating;
import demo.facts.UnauthorizedRecommendedBooks;
import demo.facts.User;
import demo.facts.UserState;
import dtos.*;
import lombok.AllArgsConstructor;

import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.repository.BooksRepository;
import sbnz.integracija.example.repository.GenreRepository;
import sbnz.integracija.example.repository.RatingRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.repository.WritersRepository;
import sbnz.integracija.example.utils.UserUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BooksService {
   private final BooksRepository booksRepository;
   private final UserRepository userRepository;
   private final RatingRepository ratingRepository;
   private final GenreRepository genreRepository;
   private final RatingsService ratingsService;
   private final WritersRepository writersRepository;
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
        if(userId == null) return getRecommendedUnauthorized();

        User user = userRepository.getOne(userId);
        AuthorizedRecommendedFavoriteGenreBooks authorizedRecommendedFavoriteGenreBooks = new AuthorizedRecommendedFavoriteGenreBooks();

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(user);
        this.getAllOtherUserRatings(user.getUsername()).forEach(kieSession::insert);
        kieSession.insert(authorizedRecommendedFavoriteGenreBooks);
        writersRepository.findAll().forEach(writer -> { kieSession.insert(writer);});

        kieSession.getAgenda().getAgendaGroup("userState").setFocus();
        kieSession.fireAllRules();

        if(user.getState()==UserState.NEW){
            kieSession.dispose();
            return getRecommendedUnauthorized();}

        kieSession.getAgenda().getAgendaGroup("oldUser").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("newGenreUser").setFocus();
        kieSession.fireAllRules();

        if(user.getState()==UserState.NEW_WITH_GENRES) return booksTobooksDto(authorizedRecommendedFavoriteGenreBooks.getTopBooks());

        Collection<Book> books = (Collection<Book>)kieSession.getObjects(new ClassObjectFilter(Book.class));

        kieSession.dispose();
        return booksTobooksDto(new ArrayList<>(books));
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


