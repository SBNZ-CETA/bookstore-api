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
    private Double cost;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCategory category;

    public Book() {}
    public Book(String title, String writer, Double cost) {
        this.title = title;
        this.writer = writer;
        this.cost = cost;
    }

    public Book(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }
}
