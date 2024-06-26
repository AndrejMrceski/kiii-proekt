package com.proekt186051.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proekt186051.order.model.Order;
import com.proekt186051.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewOrder(@RequestBody Order order) {
        try {
            Order newOrder = orderService.addNewOrderWithItems(order, order.getItems());
            return new ResponseEntity<>(newOrder, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*@PostMapping("/add1")
    public ResponseEntity<?> addNewOrder(@RequestBody OrderDTO orderDTO) {
        try {
            System.out.println(orderDTO);
            Order newOrder = new Order();
            newOrder.setOrderNo(orderDTO.getOrderNo());
            newOrder.setOrderDate(orderDTO.getOrderDate());
            newOrder.setStatus(orderDTO.getStatus());
            newOrder.setAddress(orderDTO.getAddress());
            newOrder.setComment(orderDTO.getComment());

            Order order = orderRepository.save(newOrder);
            System.out.println(order);
            order.setItems(
                orderDTO.getItems().stream()
                .map(item -> {
                    System.out.println("===============");
                    System.out.println(item);
                    System.out.println("===============");
                    Product product = productRepository.getReferenceById(item.getProduct_id());
                    LineItem newItem = new LineItem();
                    newItem.setProduct(product);
                    newItem.setOrder(order);
                    newItem.setQuantity(item.getQuantity());
                    return newItem;
                })
                .collect(Collectors.toList()));
        
            Order savedOrder = orderRepository.save(order);
            System.out.println(savedOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {
        try {
            List<Order> orders = orderService.findAll();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
