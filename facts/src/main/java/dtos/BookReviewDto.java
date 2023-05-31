package dtos;

import lombok.Data;

@Data
public class BookReviewDto {
    private Long bookId;
    private int rate;
}
