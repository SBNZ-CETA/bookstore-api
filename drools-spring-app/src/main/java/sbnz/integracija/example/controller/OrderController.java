package sbnz.integracija.example.controller;

import demo.facts.PaymentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import dtos.CreateOrderDto;
import dtos.OrderDto;
import sbnz.integracija.example.service.HttpClientService;
import sbnz.integracija.example.service.OrderService;

@RestController
@RequestMapping(path="/order")
@CrossOrigin("http://localhost:4200")
public class OrderController {
    private final OrderService orderService;
    private final HttpClientService httpClientService;
    public OrderController(OrderService orderService, HttpClientService httpClientService) {
        this.orderService = orderService;
        this.httpClientService = httpClientService;
    }

    @PostMapping(produces = "application/json")
    @PreAuthorize("hasAuthority('REGULAR')")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        if (createOrderDto.getPaymentType()== PaymentType.CREDIT_CARD){
           if (!httpClientService.payWithCard(createOrderDto.getTransactionDto())){
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
        }
        return new ResponseEntity<>(orderService.create(createOrderDto), HttpStatus.CREATED);
    }

    @PostMapping(value="/checkout",produces = "application/json")
    @PreAuthorize("hasAuthority('REGULAR')")
    public ResponseEntity<CreateOrderDto> checkout(@RequestBody CreateOrderDto createOrderDto) {
        return new ResponseEntity<>(orderService.checkout(createOrderDto), HttpStatus.CREATED);
    }
}
