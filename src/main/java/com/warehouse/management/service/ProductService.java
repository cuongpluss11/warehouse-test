package com.warehouse.management.service;

import com.warehouse.management.dto.ProductDto;
import com.warehouse.management.entity.ProductEntity;
import com.warehouse.management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(e -> new ProductDto(e.getId(), e.getSku(), e.getName(), e.getQuantity(), e.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductDto dto) {
        ProductEntity entity = new ProductEntity(dto.getSku(), dto.getName(), dto.getQuantity(), dto.getPrice());
        ProductEntity saved = productRepository.save(entity);
        return new ProductDto(saved.getId(), saved.getSku(), saved.getName(), saved.getQuantity(), saved.getPrice());
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}