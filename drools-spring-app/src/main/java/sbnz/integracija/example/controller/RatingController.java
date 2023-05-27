package sbnz.integracija.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.RatingDto;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.service.RatingsService;

@RestController
@AllArgsConstructor
@RequestMapping(path="/ratings")
@CrossOrigin( value = "http://localhost:4200" , maxAge = 3600 )
public class RatingController {

    private final RatingsService ratingsService;



    @GetMapping(produces = "application/json")
    public ResponseEntity<List<RatingDto>> getAll() {
       return new ResponseEntity<>(ratingsService.getAllRatingDtos(), HttpStatus.OK);
    }
    
}
