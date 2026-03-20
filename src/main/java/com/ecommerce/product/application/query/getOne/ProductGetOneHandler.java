package com.ecommerce.product.application.query.getOne;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.exception.ProductNotFoundException;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductGetOneHandler implements RequestHandler<ProductGetOneRequest, ProductGetOneResponse> {

    private final ProductRepository productRepository;


    @Override
    public ProductGetOneResponse handle(ProductGetOneRequest request) {
        log.info("Getting product with id {}", request.getId());
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));
        log.info("Found product with id {}", request.getId());
        return new ProductGetOneResponse(product);
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductGetOneRequest> getRequestType() {
        return ProductGetOneRequest.class;
    }
}
