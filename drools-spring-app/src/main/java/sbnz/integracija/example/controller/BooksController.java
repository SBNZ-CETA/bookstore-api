package sbnz.integracija.example.controller;

import demo.facts.Book;
import demo.facts.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.example.service.BooksService;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BooksService booksService;

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Book>> getAll() {
       return new ResponseEntity<>(booksService.getAll(), HttpStatus.OK);
    }
}
