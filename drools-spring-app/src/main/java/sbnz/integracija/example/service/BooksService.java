package sbnz.integracija.example.service;

import demo.facts.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.repository.BooksRepository;

import java.util.List;

@Service
public class BooksService {
   @Autowired
    BooksRepository booksRepository;

   public List<Book> getAll() {
       return booksRepository.findAll();
   }

}
