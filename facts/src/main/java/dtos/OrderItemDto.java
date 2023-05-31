package dtos;

import demo.facts.Book;
import demo.facts.BookCategory;
import lombok.Data;

@Data
public class OrderItemDto {
    private Long bookId;
    private GenreDto genre;
    private Integer quantity;
    private Double price;

    public OrderItemDto() {
    }

    public OrderItemDto(OrderItemDto orderItemDto) {
        this.bookId = orderItemDto.getBookId();
        this.genre = orderItemDto.getGenre();
        this.quantity = orderItemDto.getQuantity();
        this.price = orderItemDto.getPrice();
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
