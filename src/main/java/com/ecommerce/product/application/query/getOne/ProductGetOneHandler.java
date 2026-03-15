package com.ecommerce.product.application.query.getOne;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.database.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGetOneHandler implements RequestHandler<ProductGetOneRequest, ProductGetOneResponse> {

    private final ProductRepository productRepository;


    @Override
    public ProductGetOneResponse handle(ProductGetOneRequest request) {
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return new ProductGetOneResponse(product);
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductGetOneRequest> getRequestType() {
        return ProductGetOneRequest.class;
    }
}
