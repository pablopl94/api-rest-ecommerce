package com.ecommerce.product.infrastructure.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;

}
