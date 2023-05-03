package sbnz.integracija.example.controller;

import demo.facts.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.service.BooksService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class BooksController {
    @Autowired
    BooksService booksService;


    @GetMapping(value = "/books", produces = "application/json")
    public ResponseEntity<List<Book>> getAll() {
       return new ResponseEntity<>(booksService.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/books", produces = "application/json")
    public ResponseEntity<Book> create(@RequestBody BookCreateDto newBook) {
        return new ResponseEntity<>(booksService.create(newBook), HttpStatus.CREATED);
    }
}
