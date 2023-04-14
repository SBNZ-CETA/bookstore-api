package demo.facts;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String writer;
    @Column
    private Long cost;

    public Book() {}
    public Book(String title, String writer, Long cost) {
        this.title = title;
        this.writer = writer;
        this.cost = cost;
    }
}
