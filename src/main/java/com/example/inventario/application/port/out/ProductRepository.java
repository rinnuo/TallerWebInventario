package com.example.inventario.application.port.out;

import com.example.inventario.application.dto.ProductDto;
import com.example.inventario.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> getAll();
    Optional<ProductDto> getById(Long id);
    ProductDto save(Product product);
    ProductDto update(Long id, Product product);  // Nuevo método
    void delete(Long id);
}