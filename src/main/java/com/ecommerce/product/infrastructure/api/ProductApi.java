package com.ecommerce.product.infrastructure.api;

import com.ecommerce.product.domain.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductApi {

    ResponseEntity<List<Product>> getAllProducts(String pageSize);

    ResponseEntity<Product> getProductById(Long id);

    ResponseEntity<Void> insertProduct(Product product);

    ResponseEntity<Void> updateProduct(Product product);

    ResponseEntity<Void> deleteProduct(Long id);

}
