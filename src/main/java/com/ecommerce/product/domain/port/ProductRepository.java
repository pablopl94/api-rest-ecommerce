package com.ecommerce.product.domain.port;

import com.ecommerce.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}
