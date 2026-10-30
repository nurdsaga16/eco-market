package com.example.ecoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecoshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
