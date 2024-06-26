package com.proekt186051.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proekt186051.order.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}