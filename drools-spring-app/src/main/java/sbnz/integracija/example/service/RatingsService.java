package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import demo.facts.Book;
import demo.facts.Rating;
import dtos.RatingDto;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.repository.BooksRepository;
import sbnz.integracija.example.repository.RatingRepository;

@Service
@AllArgsConstructor
public class RatingsService {
        
    private final RatingRepository ratingRepository;
    private final BooksRepository booksRepository;

    @PostConstruct
    public void initialize() {
        LoadAllImportRatings();
    }

    private List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public List<RatingDto> getAllRatingDtos() {
        List<Rating> ratings = getAll();
        return genresToGenresDto(ratings);
    }

    private void LoadAllImportRatings(){
        List<Book> books = booksRepository.findAll();
        books.stream().forEach(book->{
            book = rateBook(book);
            booksRepository.save(book);
        });
    }

    public Book rateBook(Book book){
        List<Rating> ratings= ratingRepository.FindAllByBookId(book.getId()).orNull();

        int ratingCount=0;
        double totalRating=0;
        
        for(Rating rate:ratings){
            ratingCount++;
            totalRating+=rate.getRate();
        }
        totalRating = totalRating/ratingCount;
        
        book.setRateCount(ratingCount);
        book.setRating(totalRating);
        return book;
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
