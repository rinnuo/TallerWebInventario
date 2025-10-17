package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.application.dto.ProductDto;
import com.example.inventario.application.port.out.ProductRepository;
import com.example.inventario.domain.models.Product;
import com.example.inventario.infrastructure.adapters.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {
    private ProductJpaRepository productJpaRepository;
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        return productJpaRepository.findAll().stream()
                .map(productMapper::ofEntityToDto)
                .toList();
    }

    @Override
    public Optional<ProductDto> getById(Long id) {
        return productJpaRepository.findById(id)
                .map(productMapper::ofEntityToDto);
    }

    @Override
    public ProductDto save(Product product) {
        ProductEntity entity = productMapper.ofModelToEntity(product);
        ProductEntity savedEntity = productJpaRepository.save(entity);
        return productMapper.ofEntityToDto(savedEntity);
    }

    @Override
    public ProductDto update(Long id, Product product) {
        ProductEntity existingEntity = productJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        existingEntity.setName(product.getName());
        existingEntity.setBrand(product.getBrand());
        existingEntity.setDescription(product.getDescription());
        existingEntity.setPrice(product.getPrice());
        existingEntity.setActive(product.isActive());

        ProductEntity updatedEntity = productJpaRepository.save(existingEntity);
        return productMapper.ofEntityToDto(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!productJpaRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
        productJpaRepository.deleteById(id);
    }
}