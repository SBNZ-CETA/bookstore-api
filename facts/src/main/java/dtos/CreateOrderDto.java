package dtos;

import lombok.Data;

import java.util.List;


@Data
public class CreateOrderDto {
    private final Long userId;
    private final List<OrderItemDto> orderItems;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
