package com.proekt186051.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proekt186051.product.model.Product;
import com.proekt186051.product.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        
        Product prod = new Product();

        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setCategory(product.getCategory());
        prod.setStockQuantity(product.getStockQuantity());

        try {
            Product newProd = productRepository.save(prod);
            return newProd;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Product> findAll() {
        try {
            List<Product> products = productRepository.findAll();
            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
