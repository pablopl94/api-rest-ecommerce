package com.ecommerce.product.infrastructure.api;

import com.ecommerce.common.mediator.Mediator;
import com.ecommerce.product.application.command.create.ProductCreateRequest;
import com.ecommerce.product.application.command.delete.ProductDeleteRequest;
import com.ecommerce.product.application.command.update.ProductUpdateRequest;
import com.ecommerce.product.application.query.getAll.ProductGetAllRequest;
import com.ecommerce.product.application.query.getAll.ProductGetAllResponse;
import com.ecommerce.product.application.query.getOne.ProductGetOneRequest;
import com.ecommerce.product.application.query.getOne.ProductGetOneResponse;
import com.ecommerce.product.infrastructure.api.dto.ProductRequestDto;
import com.ecommerce.product.infrastructure.api.dto.ProductResponseDto;
import com.ecommerce.product.infrastructure.api.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
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
        ProductGetAllResponse products = mediator.dispatch(new ProductGetAllRequest());
        List<ProductResponseDto> response = products.getProducts().stream()
                .map(productMapper::mapProductToResponse)
                .toList();
        return ResponseEntity.ok(response);
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
    public ResponseEntity<Void> insertProduct(
            @RequestPart("data") @Valid ProductRequestDto productRequestDto,
            @RequestPart(value = "image", required = false) MultipartFile file) {
        ProductCreateRequest request = productMapper.mapRequestToCreate(productRequestDto);
        Long responseId = mediator.dispatch(request);
        return ResponseEntity.created(URI.create("/api/v1/products/" + responseId)).build();
    }

    @Override
    @PutMapping(value = "{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long id,
            @RequestPart("data") @Valid ProductRequestDto productRequestDto,
            @RequestPart(value = "image", required = false) MultipartFile file) {
        ProductUpdateRequest request = productMapper.mapRequestToUpdate(productRequestDto);
        request.setId(id);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        mediator.dispatch(new ProductDeleteRequest(id));
        return ResponseEntity.noContent().build();
    }
}
