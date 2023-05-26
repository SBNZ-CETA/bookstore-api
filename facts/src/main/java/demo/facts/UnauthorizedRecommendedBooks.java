package demo.facts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnauthorizedRecommendedBooks {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void add(Book book){
        books.add(book);
    }

    public void removeBadlyRatedBooks(){
        while(haveBadlyRatedBooks()) {
            books.remove(getBadlyRecommendedBook(books));
        }
    }

    public Book getBadlyRecommendedBook(List<Book> list){
        for (Book book : list) {
            if (book.getRateUnit() == RateUnit.BAD) {
                System.out.println(book.getRateUnit());
                return book;
            }
        }
        return null;
    }

    public boolean haveBadlyRatedBooks(){
        for (Book book : books) {
            if (book.getRateUnit() == RateUnit.BAD) {
                return true;
            }
        }
        return false;
    }

    public void pickTenBooks(){
        while(books.size() > 10){
            books.remove(getRandomElement(books));
        }
    }

    public Book getRandomElement(List<Book> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
