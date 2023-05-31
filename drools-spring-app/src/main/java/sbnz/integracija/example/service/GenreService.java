package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import demo.facts.Genre;
import dtos.GenreDto;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.repository.GenreRepository;


@Service
@AllArgsConstructor
public class GenreService {
    
    private final GenreRepository genreRepository;

    public List<GenreDto> getAllGenreDtos() {
        List<Genre> genres = getAll();
        return genresToGenresDto(genres);
    }
    
    private List<Genre> getAll() {
        return genreRepository.findAll();
    }

    private List<GenreDto> genresToGenresDto(List<Genre> genres) {
        List<GenreDto> genreDtos = new ArrayList<>();
                genres.stream().forEach(genre -> { 
                GenreDto dto = new GenreDto(genre);
                genreDtos.add(dto);
            });
        return genreDtos;
    }
}
