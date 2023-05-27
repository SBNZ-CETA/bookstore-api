package dtos;

import demo.facts.Genre;
import lombok.Data;

@Data
public class GenreDto {
    private Long id;
    private String name;

    public GenreDto(Genre genre){
        this.id = genre.getId();
        this.name = genre.getName();
    }

}
