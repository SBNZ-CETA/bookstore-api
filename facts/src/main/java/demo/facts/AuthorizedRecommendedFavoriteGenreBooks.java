package demo.facts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class AuthorizedRecommendedFavoriteGenreBooks {
    private List<Writer> allWriters= new ArrayList<>();
    private List<Writer> topWriters= new ArrayList<>();
    private List<Book> allBooks = new ArrayList<>();
    private List<Book> topBooks = new ArrayList<>();

    public void addWriter(Writer writer){
        List<Writer> list = allWriters.stream().filter(w -> w.getId()==writer.getId()).collect(Collectors.toList());
        if(list.isEmpty()) allWriters.add(writer);
    }

    public void addPopularWriter(Writer writer){
        // List<Writer> list = allWriters.stream().filter(w -> w.getId()==writer.getId()).collect(Collectors.toList());
        // if(list.isEmpty()) 
        topWriters.add(writer);
    }

    public void addBook(Book book){
        List<Book> list = allBooks.stream().filter(b -> b.getId()==book.getId()).collect(Collectors.toList());
        if(list.isEmpty()) allBooks.add(book);
    }

    public void addPopularBook(Book book){
       topBooks.add(book);
    }

    public Writer getPopularWriterAndDelete(){
        Writer mostPopular = allWriters.stream()
            .min(Comparator.comparing(Writer::getWriterRatingSum))
            .orElse(null);
        if (mostPopular!= null) {
            allWriters.remove(mostPopular);
            return mostPopular;
        }else{
            return new Writer(true);
        }  
    }

    public Book getPopularBookAndDelete(){
        Book mostPopular = allBooks.stream()
            .min(Comparator.comparing(Book::getRating))
            .orElse(null);
        if (mostPopular!= null) {
            allBooks.remove(mostPopular);
            return mostPopular;
        }else{
            return new Book(true);
        }
       
    }

    // public List<Writer> orderedWriters(List<Genre> wantedGenres){
    // }

}
