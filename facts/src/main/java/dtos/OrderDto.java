package dtos;

import demo.facts.OrderStatus;
import demo.facts.PaymentType;
import lombok.Data;

@Data
public class OrderDto {
    private Double totalPrice;
    private String username;
    private OrderStatus status;
    private PaymentType paymentType;
}
