package com.ecommerce.product.application.command.delete;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductDeleteHandler implements RequestHandler<ProductDeleteRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductDeleteRequest request) {
        log.info("Deleting product with id {}", request.getId());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        productRepository.deleteById(request.getId());

        log.info("Deleted product with id {}", request.getId());
        return null;
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductDeleteRequest> getRequestType() {
        return ProductDeleteRequest.class;
    }
}
