package sbnz.integracija.example.controller;

import demo.facts.Book;
import dtos.CheckoutDto;
import dtos.CreateOrderDto;
import dtos.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.service.OrderService;

@RestController
@RequestMapping(path="/order")
@CrossOrigin("http://localhost:4200")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CheckoutDto checkoutDto) {
        return new ResponseEntity<>(orderService.create(checkoutDto), HttpStatus.CREATED);
    }

    @PostMapping(value="/checkout",produces = "application/json")
    public ResponseEntity<CheckoutDto> checkout(@RequestBody CreateOrderDto createOrderDto) {
        return new ResponseEntity<>(orderService.checkout(createOrderDto), HttpStatus.CREATED);
    }
}
