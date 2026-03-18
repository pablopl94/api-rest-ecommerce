package com.ecommerce.product.application.query.getAll;

import com.ecommerce.common.mediator.RequestHandler;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGetAllHandler implements RequestHandler<ProductGetAllRequest, ProductGetAllResponse> {

    private final ProductRepository productRepository;


    @Override
    public ProductGetAllResponse handle(ProductGetAllRequest request) {
        List<Product> products = productRepository.findAll();
        return new ProductGetAllResponse(products);
    }

    //Define la clase del tipo de entrada
    //Se podría hacer con reflexión directamente pero consume más memoria
    @Override
    public Class<ProductGetAllRequest> getRequestType() {
        return ProductGetAllRequest.class;
    }
}
