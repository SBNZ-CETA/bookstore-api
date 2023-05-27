package sbnz.integracija.example.controller;

import demo.facts.Book;
import demo.facts.Genre;
import demo.facts.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.BookCreateDto;
import sbnz.integracija.example.dto.BookDto;
import sbnz.integracija.example.dto.BookReviewDto;
import sbnz.integracija.example.service.BooksService;

import java.util.List;

@RestController
@CrossOrigin( value = "http://localhost:4200" , maxAge = 3600 )
public class BooksController {
    @Autowired
    BooksService booksService;


    @GetMapping(value = "/books", produces = "application/json")
    public ResponseEntity<List<BookDto>> getAll() {
       return new ResponseEntity<>(booksService.getAllBookDtos(), HttpStatus.OK);
    }
    @PostMapping(value = "/books", produces = "application/json")
    public ResponseEntity<Book> create(@RequestBody BookCreateDto newBook) {
        return new ResponseEntity<>(booksService.create(newBook), HttpStatus.CREATED);
    }
    @PostMapping(value = "/review", produces = "application/json")
    public ResponseEntity<Rating> review(@RequestBody BookReviewDto reviewDto){
        return new ResponseEntity<>(booksService.review(reviewDto), HttpStatus.OK);
    }
    @GetMapping(value = "/recommend-unauthorized", produces = "application/json")
    public ResponseEntity<List<BookDto>> getRecommendedUnauthorized() {
        return new ResponseEntity<>(booksService.getRecommendedUnauthorized(), HttpStatus.OK);
    }
    @GetMapping(value = "/books/categories",produces = "application/json")
    public ResponseEntity<List<Genre>> getPossibleCategories() {
        return new ResponseEntity<>(booksService.getAllBookGenres(), HttpStatus.OK);
    }

    @GetMapping(value = "/recommend-authorized",produces = "application/json")
    public ResponseEntity<List<BookDto>> getReccommendedAuthorized(){
        return new ResponseEntity<>(booksService.getReccommendedAuthorized(),HttpStatus.OK);
    }
}
