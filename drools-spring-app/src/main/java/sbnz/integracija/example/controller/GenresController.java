package sbnz.integracija.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sbnz.integracija.example.dto.GenreDto;
import sbnz.integracija.example.service.GenreService;

@RestController
@AllArgsConstructor
@RequestMapping(path="/genres")
@CrossOrigin( value = "http://localhost:4200" , maxAge = 3600 )
public class GenresController {
    private final GenreService genreService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<GenreDto>> getAll() {
       return new ResponseEntity<>(genreService.getAllGenreDtos(), HttpStatus.OK);
    }
}
