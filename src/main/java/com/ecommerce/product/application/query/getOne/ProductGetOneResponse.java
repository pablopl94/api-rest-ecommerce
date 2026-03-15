package com.ecommerce.product.application.query.getOne;

import com.ecommerce.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetOneResponse {
    private Product product;

}
