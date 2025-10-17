package com.example.inventario.application.services;

import com.example.inventario.application.dto.ProductDto;
import com.example.inventario.application.port.out.ProductRepository;
import com.example.inventario.domain.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDto> getById(Long id) {
        return productRepository.getById(id);
    }

    public ProductDto save(Product product) {
        return productRepository.save(product);
    }

    public ProductDto update(Long id, Product product) {
        return productRepository.update(id, product);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}