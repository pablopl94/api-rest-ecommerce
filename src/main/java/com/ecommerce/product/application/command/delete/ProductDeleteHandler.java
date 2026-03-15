package com.ecommerce.product.application.command.delete;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.infrastructure.database.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteHandler implements RequestHandler<ProductDeleteRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductDeleteRequest request) {
        productRepository.deleteById(request.getId());
        return null;
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductDeleteRequest> getRequestType() {
        return ProductDeleteRequest.class;
    }
}
