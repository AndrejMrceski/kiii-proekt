package com.proekt186051.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proekt186051.product.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByOrderNo(String orderNo);
}