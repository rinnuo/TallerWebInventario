package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.application.dto.ProductDto;
import com.example.inventario.domain.models.Product;
import com.example.inventario.infrastructure.adapters.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductEntity ofModelToEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setBrand(product.getBrand());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setActive(product.isActive());
        return entity;
    }

    public ProductDto ofEntityToDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getBrand(),
                entity.getDescription(),
                entity.getPrice(),
                entity.isActive()
        );
    }
}