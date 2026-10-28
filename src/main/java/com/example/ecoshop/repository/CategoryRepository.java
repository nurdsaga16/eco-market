package com.example.ecoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecoshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    
} 
