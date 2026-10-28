package com.example.ecoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecoshop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

} 
