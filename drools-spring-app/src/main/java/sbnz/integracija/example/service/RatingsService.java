package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import demo.facts.Rating;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.dto.RatingDto;
import sbnz.integracija.example.repository.RatingRepository;

@Service
@AllArgsConstructor
public class RatingsService {
        
    private final RatingRepository ratingRepository;

    private List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public List<RatingDto> getAllRatingDtos() {
        List<Rating> ratings = getAll();
        return genresToGenresDto(ratings);
    }

    private List<RatingDto> genresToGenresDto(List<Rating> ratings) {
        List<RatingDto> ratingDtos = new ArrayList<>();
                ratings.stream().forEach(rating -> { 
                    RatingDto dto = new RatingDto(rating);
                    ratingDtos.add(dto);
            });
        return ratingDtos;
    }
}
