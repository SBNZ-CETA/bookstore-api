package dtos;

import java.util.List;

public class CheckoutDto {
    private Long userId;
    private List<OrderItemDto> orderItems;
    private Double discountedPrice;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
