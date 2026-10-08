package com.warehouse.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private Integer quantity;
    private Double price;

    public ProductEntity() {}

    public ProductEntity(String sku, String name, Integer quantity, Double price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getSku() { return sku; }
    public String getName() { return name; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
}