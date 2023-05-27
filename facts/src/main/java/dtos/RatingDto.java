package dtos;

import demo.facts.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatingDto {
    private Long id;
    private Long user_id;
    private Long book_id;
    private int rate;

    public RatingDto(Rating rating){
        this.id = rating.getId();
        this.user_id = rating.getUser().getId();
        this.book_id = rating.getBook().getId();
        this.rate = rating.getRate();
    }
}
