package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatingDto {
    private Long id;
    private Long user_id;
    private int rate;
}
