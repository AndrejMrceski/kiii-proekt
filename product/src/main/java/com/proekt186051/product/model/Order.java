package com.proekt186051.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "orders")
public class Order {

    public enum OrderStatus {
        PENDING, SHIPPED, DELIVERED, CANCELED, COMPLETED
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_no")
    private String orderNo;
    
    @Column(name = "order_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name="address")
    private String address;

    @Column(name="comment", columnDefinition = "varchar(1000) default ''")
    private String comment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LineItem> items = new ArrayList<>();

    @Override
    public String toString() {
        String result = this.orderNo;
        result += " --- ";
        result += this.status;
        result += " --- ";
        result += this.items.toString();
        return result;
    }
}