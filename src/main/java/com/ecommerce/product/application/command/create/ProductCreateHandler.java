package com.ecommerce.product.application.command.create;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.common.util.FileUtils;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Long> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public Long handle(ProductCreateRequest request) {
        log.info("Saving new Product");

        String uniqueFileName = fileUtils.handleProductImage(request.getImage(), null);

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFileName)
                .build();

        productRepository.save(product);

        log.info("Saved product with id {}", product.getId());
        return product.getId();
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductCreateRequest> getRequestType() {
        return ProductCreateRequest.class;
    }
}
