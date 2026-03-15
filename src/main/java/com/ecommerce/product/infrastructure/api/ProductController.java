package com.ecommerce.product.infrastructure.api;

import com.ecommerce.common.mediator.Mediator;
import com.ecommerce.product.application.command.create.ProductCreateRequest;
import com.ecommerce.product.application.query.getOne.ProductGetOneRequest;
import com.ecommerce.product.application.query.getOne.ProductGetOneResponse;
import com.ecommerce.product.infrastructure.api.dto.ProductRequestDto;
import com.ecommerce.product.infrastructure.api.dto.ProductResponseDto;
import com.ecommerce.product.infrastructure.api.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @Override
    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(@RequestParam(required = false) String pageSize) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductGetOneResponse product = mediator.dispatch(new ProductGetOneRequest(id));
        ProductResponseDto response = productMapper.mapProductToResponse(product.getProduct());
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> insertProduct(@RequestBody ProductRequestDto productRequestDto) {
        ProductCreateRequest request = productMapper.mapRequestToCreate(productRequestDto);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping()
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return null;
    }
}
