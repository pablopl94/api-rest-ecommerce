package com.ecommerce.product.infrastructure.api.dto;

public record ProductRequestDto(
        String name,
        String description,
        Double price,
        String image
) {
}
