package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.infrastructure.adapters.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}