package com.example.ecoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecoshop.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    
}
