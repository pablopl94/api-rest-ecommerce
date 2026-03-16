package com.ecommerce.product.infrastructure.api;

import com.ecommerce.product.infrastructure.api.dto.ProductRequestDto;
import com.ecommerce.product.infrastructure.api.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductApi {

    ResponseEntity<List<ProductResponseDto>> getAllProducts(String pageSize);

    ResponseEntity<ProductResponseDto> getProductById(Long id);

    ResponseEntity<Void> insertProduct(ProductRequestDto productRequestDto);

    ResponseEntity<Void> updateProduct(ProductRequestDto productRequestDto);

    ResponseEntity<Void> deleteProduct(Long id);

}
