package com.example.inventario.application.port.in;

import com.example.inventario.application.dto.ProductDto;
import java.util.List;
import java.util.Optional;

public interface ProductUseCase {
    List<ProductDto> getAllProducts();
    Optional<ProductDto> getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
    ProductDto activateProduct(Long id);
    ProductDto deactivateProduct(Long id);
}