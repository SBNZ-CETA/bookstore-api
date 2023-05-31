package sbnz.integracija.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.WriterDto;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.service.WritersService;

@RestController
@AllArgsConstructor
@RequestMapping(path="/writers")
@CrossOrigin( value = "http://localhost:4200" , maxAge = 3600 )
public class WritersController {

    private WritersService writersService;
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<WriterDto>> getAll() {
       return new ResponseEntity<>(writersService.getAllWriterDtos(), HttpStatus.OK);
    }

    @GetMapping(path = "/rating/{id}",produces = "application/json")
    public ResponseEntity<Integer> getRatingFor(@PathVariable Long id) {
       return new ResponseEntity<>(writersService.getWriterRating(id), HttpStatus.OK);
    }
}
