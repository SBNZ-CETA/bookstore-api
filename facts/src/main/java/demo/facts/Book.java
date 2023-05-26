package demo.facts;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "books")
@AllArgsConstructor
@Getter
@Setter
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
    @Column
    private LocalDateTime publishDate;
    @Column
    private LocalDateTime releaseDate;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Rating> ratings;
    private Double rating;
    private int rateCount;
    @Transient
    private boolean isNew;
    @Transient
    private boolean isPopular;
    @Transient
    @Enumerated(EnumType.STRING)
    private RateUnit rateUnit;

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

    // public void addNewRating(int rating){
    //     this.rating = ((this.rateCount*this.rating) + rating) / (this.rateCount + 1);
    //     this.rateCount = this.rateCount + 1;
    // }
}
