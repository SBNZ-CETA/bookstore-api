package sbnz.integracija.example.service;

import demo.facts.Book;
import org.dmg.pmml.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.repository.BooksRepository;

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
       return booksRepository.save(modelMapper.map(newBook, Book.class));
   }
}
