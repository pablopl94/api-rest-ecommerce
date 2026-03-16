package com.ecommerce.product.application.query.getAll;

import com.ecommerce.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetAllResponse {
    private List<Product> products;

}
