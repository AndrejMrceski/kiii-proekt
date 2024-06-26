package com.proekt186051.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proekt186051.order.model.LineItem;
import com.proekt186051.order.model.Order;
import com.proekt186051.order.model.Product;
import com.proekt186051.order.repository.OrderRepository;
import com.proekt186051.order.repository.ProductRepository;

@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order addNewOrderWithItems(Order order, List<LineItem> items) {
        try {
            Order newOrder = new Order();
            newOrder.setOrderNo(order.getOrderNo());
            newOrder.setOrderDate(order.getOrderDate());
            newOrder.setStatus(order.getStatus());
            newOrder.setAddress(order.getAddress());
            newOrder.setComment(order.getComment());
            newOrder.getItems().addAll((items
                .stream()
                .map(item -> {
                    Product product = productRepository.getReferenceById(item.getProduct().getId());
                    LineItem newItem = new LineItem();
                    newItem.setProduct(product);
                    newItem.setOrder(newOrder);
                    newItem.setQuantity(item.getQuantity());
                    return newItem;
                })
                .collect(Collectors.toList())));
            
            Order savedOrder = orderRepository.save(newOrder);
            return savedOrder;
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<Order> findAll() {
        try {
            return orderRepository.findAll();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
