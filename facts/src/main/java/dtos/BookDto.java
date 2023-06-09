package dtos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import demo.facts.Book;
import demo.facts.BookCategory;
import demo.facts.RateUnit;
import demo.facts.Rating;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private WriterDto writer;
    private Double cost;
    private GenreDto genre;
    private LocalDateTime publishDate;
    private LocalDateTime releaseDate;
    private Set<RatingDto> ratings;
    private Double rating;
    private int rateCount;
    private boolean isNew;
    private boolean popular;
    private RateUnit rateUnit;
    private Long sellerBankAccountId;

    public BookDto(Book book){
        Set<Rating> ratings = book.getRatings();
        Set<RatingDto> ratingsDto = new HashSet<>();
        ratings.stream().forEach(rating -> {
            ratingsDto.add(new RatingDto(rating));
        }); 

        this.id = book.getId();
        this.title = book.getTitle();
        this.writer = new WriterDto(book.getWriter());
        this.cost = book.getCost();
        this.genre = new GenreDto(book.getGenre());
        this.publishDate = book.getPublishDate();
        this.releaseDate = book.getReleaseDate();
        this.rating = book.getRating();
        this.rateCount = book.getRateCount();
        this.isNew = book.isNew();
        this.popular = book.isPopular();
        this.rateUnit = book.getRateUnit();
        this.ratings = ratingsDto;
        this.sellerBankAccountId = book.getSellerBankAccountId();
    }


}    

