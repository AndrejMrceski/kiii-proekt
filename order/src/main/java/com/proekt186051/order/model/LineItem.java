package com.proekt186051.order.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "line_item")
public class LineItem {
    
    @EmbeddedId
    private LineItemKey id = new LineItemKey();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;
        
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public String toString() {
        String result = this.product.getId().toString();
        result += " --- ";
        result += this.order.getId().toString();
        result += " --- ";
        result += this.quantity.toString();
        return result;
    }
}