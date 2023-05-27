package sbnz.integracija.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import sbnz.integracija.example.dto.CreateOrderDto;
import sbnz.integracija.example.dto.OrderDto;
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
    @PreAuthorize("hasAuthority('REGULAR')")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        return new ResponseEntity<>(orderService.create(createOrderDto), HttpStatus.CREATED);
    }

    @PostMapping(value="/checkout",produces = "application/json")
    @PreAuthorize("hasAuthority('REGULAR')")
    public ResponseEntity<CreateOrderDto> checkout(@RequestBody CreateOrderDto createOrderDto) {
        return new ResponseEntity<>(orderService.checkout(createOrderDto), HttpStatus.CREATED);
    }
}
