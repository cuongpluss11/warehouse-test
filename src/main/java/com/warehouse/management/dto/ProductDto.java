package com.warehouse.management.dto;

public class ProductDto {
    private Long id;
    private String sku;
    private String name;
    private Integer quantity;
    private Double price;

    public ProductDto() {}

    public ProductDto(Long id, String sku, String name, Integer quantity, Double price) {
        this.id = id;
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