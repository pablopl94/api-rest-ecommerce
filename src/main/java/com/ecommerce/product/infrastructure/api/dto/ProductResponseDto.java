package com.ecommerce.product.infrastructure.api.dto;

public record ProductResponseDto(
        Long id,
        String name,
        String description,
        Double price,
        String image
) {
}
