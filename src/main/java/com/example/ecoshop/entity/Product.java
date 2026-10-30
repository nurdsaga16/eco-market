package com.example.ecoshop.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.ColumnDefault;
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
    name = "products",
    check = {
        @CheckConstraint(
            name = "chk_products_price",
            constraint = "price > 0"
        ),
        @CheckConstraint(
            name = "chk_products_stock",
            constraint = "stock >= 0"
        )
    }
)
@Builder
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true, length = 150)
    private String productName;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    @ColumnDefault("0")
    private int stock;

    @CreationTimestamp 
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp 
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
