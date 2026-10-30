package com.example.ecoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecoshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
