package com.proekt186051.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proekt186051.order.model.LineItem;
import com.proekt186051.order.model.LineItemKey;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, LineItemKey> {
    
}