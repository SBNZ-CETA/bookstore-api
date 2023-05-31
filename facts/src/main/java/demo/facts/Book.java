package demo.facts;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
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
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Writer writer;
    @Column
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
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
    @Transient
    private boolean isEmpty = false;

    public Book() {}
    public Book(boolean empty) {
        this.isEmpty = empty;
    }
    public Book(String title, Writer writer, Double cost) {
        this.title = title;
        this.writer = writer;
        this.cost = cost;
    }


    public int getBookRatingSum(){
        return ratings.stream()
        .map(x -> x.getRate())
        .reduce(0, Integer::sum);
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

    public Genre getGenre() {
        return genre;
    }

    public void setCategory(Genre genre) {
        this.genre = genre;
    }

    // public void addNewRating(int rating){
    //     this.rating = ((this.rateCount*this.rating) + rating) / (this.rateCount + 1);
    //     this.rateCount = this.rateCount + 1;
    // }
}
