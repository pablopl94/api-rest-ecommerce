package com.ecommerce.product.application.command.update;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.common.util.FileUtils;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.exception.ProductNotFoundException;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public Void handle(ProductUpdateRequest request) {
        log.info("Update product with id {}", request.getId());

        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new ProductNotFoundException(request.getId()));

        String uniqueFileName = fileUtils.handleProductImage(request.getImage(), product.getImage());

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImage(uniqueFileName);

        productRepository.save(product);

        log.info("Updated product with id {}", product.getId());
        return null;
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductUpdateRequest> getRequestType() {
        return ProductUpdateRequest.class;
    }
}
