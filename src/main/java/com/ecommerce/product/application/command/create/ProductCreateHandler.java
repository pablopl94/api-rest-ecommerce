package com.ecommerce.product.application.command.create;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.database.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductCreateRequest request) {

        Product product = Product.builder()
                .id(UUID.randomUUID().getMostSignificantBits())
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
    public Class<ProductCreateRequest> getRequestType() {
        return ProductCreateRequest.class;
    }
}
