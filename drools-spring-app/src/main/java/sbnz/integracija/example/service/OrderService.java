package sbnz.integracija.example.service;

import demo.facts.Book;
import demo.facts.Order;
import demo.facts.OrderItem;
import demo.facts.OrderStatus;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.dto.CreateOrderDto;
import sbnz.integracija.example.dto.OrderDto;
import sbnz.integracija.example.dto.OrderItemDto;
import sbnz.integracija.example.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BooksService booksService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final KieContainer kieContainer;

    public OrderService(OrderRepository orderRepository,ModelMapper modelMapper, BooksService booksService, UserService userService, KieContainer kieContainer){
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.booksService = booksService;
        this.userService = userService;
        this.kieContainer = kieContainer;
    }

    public OrderDto create(CreateOrderDto createOrderDto){
        Order order = new Order();
        order.setUser(userService.getByUsername(createOrderDto.getUsername()));
        order.setPaymentType(createOrderDto.getPaymentType());
        order.setTotalPrice(createOrderDto.getTotalPrice());
        order.setOrderItems(mapDtoItemsToEntity(createOrderDto.getOrderItems(), order));
        order.setStatus(OrderStatus.CREATED);

        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }

    public CreateOrderDto checkout(CreateOrderDto createOrderDto) {

        setBookAttributesAndPrices(createOrderDto);

        List<OrderItemDto> orderItemsWithInitialPrices = copyWithInitialPrices(createOrderDto.getOrderItems());
        double itemDiscountPrice = calculatePriceOfItemDiscount(createOrderDto);

        applyOrderDiscount(createOrderDto);

        if(itemDiscountPrice < createOrderDto.getTotalPrice()){
            createOrderDto.setTotalPrice(itemDiscountPrice);
            createOrderDto.setOrderItems(createOrderDto.getOrderItems());
        }else{
            createOrderDto.setTotalPrice(createOrderDto.getTotalPrice());
            createOrderDto.setOrderItems(orderItemsWithInitialPrices);
        }

        return createOrderDto;
    }

    private double calculatePriceOfItemDiscount(CreateOrderDto createOrderDto){
        double itemDiscountPrice = 0;
        for (OrderItemDto orderItem : createOrderDto.getOrderItems()) {
            applyItemDiscount(orderItem);
            itemDiscountPrice += orderItem.getPrice();
        }
        return itemDiscountPrice;
    }

    private void applyItemDiscount(OrderItemDto orderItem) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("itemDiscount").setFocus();
        kieSession.insert(orderItem);
        kieSession.insert(orderItem.getPrice());
        kieSession.fireAllRules();
        kieSession.dispose();
    }
    private void applyOrderDiscount(CreateOrderDto order) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("orderDiscount").setFocus();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    private List<OrderItem> mapDtoItemsToEntity(List<OrderItemDto> orderItemDtos, Order order) {
        return orderItemDtos.stream()
                .map(orderItemDto -> {
                    Book book = booksService.getById(orderItemDto.getBookId());
                    OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
                    orderItem.setBook(book);
                    orderItem.setOrder(order);
                    return orderItem;
                })
                .collect(Collectors.toList());
    }

    private List<OrderItemDto> copyWithInitialPrices(List<OrderItemDto> orderItemDtos){
        return orderItemDtos.stream()
                .map(orderItemDto -> {
                    OrderItemDto copiedOrderItem = new OrderItemDto(orderItemDto);
                    return copiedOrderItem;
                })
                .collect(Collectors.toList());
    }

    private void setBookAttributesAndPrices(CreateOrderDto createOrderDto){
        List<OrderItemDto> orderItems = createOrderDto.getOrderItems();
        orderItems.stream().forEach(orderItem -> {
            Book book = booksService.getById(orderItem.getBookId());
            orderItem.setBookCategory(book.getCategory());
            orderItem.setPrice(book.getCost() * orderItem.getQuantity());
        });
        createOrderDto.setTotalPrice(orderItems.stream().mapToDouble(OrderItemDto::getPrice).sum());
    }
}
