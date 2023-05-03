package dtos;

import demo.facts.PaymentType;
import lombok.Data;

import java.util.List;


@Data
public class CreateOrderDto {
    private final String username;
    private List<OrderItemDto> orderItems;
    private Double totalPrice;
    private final PaymentType paymentType;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}