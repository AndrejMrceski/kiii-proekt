package com.proekt186051.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proekt186051.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}