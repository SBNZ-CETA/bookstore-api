package dtos;

import demo.facts.Book;
import demo.facts.BookCategory;
import lombok.Data;

@Data
public class BookCreateDto {
    private String title;
    private String writer;
    private Double cost;
    private BookCategory category;

}
