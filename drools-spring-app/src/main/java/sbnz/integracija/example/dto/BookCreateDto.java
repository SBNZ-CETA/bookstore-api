package sbnz.integracija.example.dto;

import demo.facts.Book;
import lombok.Data;

@Data
public class BookCreateDto {
    private String title;
    private String writer;
    private Long cost;

    public Book toEntity() {
        return new Book(this.title, this.writer, this.cost);
    }
}
