package sbnz.integracija.example.service;

import demo.facts.Book;
import org.dmg.pmml.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.dto.BookReviewDto;
import sbnz.integracija.example.repository.BooksRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BooksService {
   @Autowired
   BooksRepository booksRepository;
   private final ModelMapper modelMapper;
   public BooksService(ModelMapper modelMapper) {
       this.modelMapper = modelMapper;
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
}
