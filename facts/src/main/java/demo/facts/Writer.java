package demo.facts;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "writers")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Writer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
    
    private String surname;
    @OneToMany (mappedBy = "writer", cascade = CascadeType.ALL)
    private Set<Book> books;
  
    @Transient
    private boolean isEmpty = false;

    public Writer(boolean empty){
        this.isEmpty=empty;
    }

    //MOGU OVDE LISTU DA PROSLEDIM I ODMA SVE DA PROVERIM U JEDNOM CUGU!
    public double getGenreRepresentationInWriter(Genre genre){
        double goodGenreCounter =  books.stream().filter(b-> b.getGenre() == genre).count();
        return goodGenreCounter/books.size();
    }

    public int getWriterRatingSum(){
        return books.stream()
        .map(x -> x.getBookRatingSum())
        .reduce(0, Integer::sum);
    }
}
