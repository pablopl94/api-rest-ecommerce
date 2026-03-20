package com.ecommerce.product.infrastructure.database;

import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.port.ProductRepository;
import com.ecommerce.product.infrastructure.database.entity.ProductEntity;
import com.ecommerce.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>();
    private final ProductEntityMapper productEntityMapper;
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public void save(Product product) {
        ProductEntity productEntity = productEntityMapper.mapProductToEntity(product);
        if (productEntity.getId() == null) {
            Long newId = idSequence.incrementAndGet();
            productEntity.setId(newId);
            product.setId(newId);
        }
        products.removeIf(p -> p.getId().equals(productEntity.getId()));
        products.add(productEntity);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
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
    @CacheEvict(value = "products", key = "#id") //Borra la cache
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
