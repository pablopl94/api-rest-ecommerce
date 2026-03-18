package com.ecommerce.product.infrastructure.database;

import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.port.ProductRepository;
import com.ecommerce.product.infrastructure.database.entity.ProductEntity;
import com.ecommerce.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void save(Product product) {
        ProductEntity productEntity = productEntityMapper.mapProductToEntity(product);
        products.removeIf(p -> p.getId().equals(productEntity.getId()));
        products.add(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapEntityToProduct);
    }

    @Override
    public List<Product> findAll() {
        return products.stream()
                .map(productEntityMapper::mapEntityToProduct)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
