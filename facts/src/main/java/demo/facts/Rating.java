package demo.facts;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "ratings")
@AllArgsConstructor
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    public Book book; 

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int rate;


    public Rating(Long book_id,Long user_id,int rate){
        this.book = new Book(book_id);
        this.user = new User(user_id);
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
       return this.book.getId().equals(((Rating)o).book.getId());
    }

}
