package com.example.ecoshop.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "categories",
    check = @CheckConstraint(
        constraint = "length(trim(category_name)) > 0"
    )
)
@Builder 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true, length = 100)
    private String categoryName;

    @CreationTimestamp 
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp 
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
