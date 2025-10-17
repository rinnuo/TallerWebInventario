package com.example.inventario.infrastructure.controllers;

import com.example.inventario.application.dto.ProductDto;
import com.example.inventario.application.dto.ProductRequestDto;
import com.example.inventario.application.services.ProductServices;
import com.example.inventario.domain.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServices productServices;

    @GetMapping
    public List<ProductDto> getAll() {
        return productServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        return productServices.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductRequestDto productRequest) {
        Product product = new Product(
                null,
                productRequest.name,
                productRequest.brand,
                productRequest.description,
                productRequest.price
        );
        return productServices.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(
            @PathVariable Long id,
            @RequestBody ProductRequestDto productRequest) {
        try {
            Product product = new Product(
                    id,
                    productRequest.name,
                    productRequest.brand,
                    productRequest.description,
                    productRequest.price
            );
            ProductDto updatedProduct = productServices.update(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            productServices.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}