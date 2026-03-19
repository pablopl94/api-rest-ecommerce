package com.ecommerce.product.application.command.delete;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductDeleteHandler implements RequestHandler<ProductDeleteRequest, Void> {

    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(ProductDeleteHandler.class);

    @Override
    public Void handle(ProductDeleteRequest request) {
        log.info("Eliminando producto con id {}", request.getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productRepository.deleteById(request.getId());
        log.info("Producto correctamente eliminado con id {}", request.getId());
        return null;
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductDeleteRequest> getRequestType() {
        return ProductDeleteRequest.class;
    }
}
