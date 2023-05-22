package sbnz.integracija.example.service;

import demo.facts.Book;
import demo.facts.RateUnit;
import demo.facts.UnauthorizedRecommendedBooks;
import org.dmg.pmml.Model;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.dto.BookReviewDto;
import sbnz.integracija.example.repository.BooksRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BooksService {
   @Autowired
   BooksRepository booksRepository;
   private final ModelMapper modelMapper;
   private final KieContainer kieContainer;
   public BooksService(ModelMapper modelMapper, KieContainer kieContainer) {
       this.modelMapper = modelMapper;
       this.kieContainer = kieContainer;
   }

   public List<Book> getAll() {
       return booksRepository.findAll();
   }
   public Book getById(Long id) {
       return booksRepository.findById(id).orElse(null);
   }
   public Book create(BookCreateDto newBook) {
       Book book = modelMapper.map(newBook, Book.class);
       book.setRating(0.);
       book.setRateCount(0);
       book.setPublishDate(LocalDateTime.now());
       book.setReleaseDate(LocalDateTime.now());
       book.setRateUnit(RateUnit.NEUTRAL);
       return booksRepository.save(book);
   }

    public Book review(BookReviewDto reviewDto) {
       if (reviewDto.getRate() > 5 || reviewDto.getRate() < 1){
           return null;
       }
       Book book = booksRepository.getOne(reviewDto.getBookId());
       book.addNewRating(reviewDto.getRate());

       return booksRepository.save(book);
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
}
