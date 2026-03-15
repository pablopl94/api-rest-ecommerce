package com.ecommerce.product.infrastructure.api;

import com.ecommerce.product.domain.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi {

    @Override
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String pageSize) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> insertProduct(@RequestBody Product product) {
        return null;
    }

    @Override
    @PutMapping()
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return null;
    }
}
