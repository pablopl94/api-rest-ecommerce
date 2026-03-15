package com.ecommerce.product.application.command.update;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.database.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductUpdateRequest request) {

        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .image(request.getImage())
                .build();

        productRepository.save(product);

        return null;
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductUpdateRequest> getRequestType() {
        return ProductUpdateRequest.class;
    }
}
