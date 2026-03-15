package com.ecommerce.product.application.query.getOne;

import com.ecommerce.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetOneRequest implements Request<ProductGetOneResponse> {
    private Long id;
}
