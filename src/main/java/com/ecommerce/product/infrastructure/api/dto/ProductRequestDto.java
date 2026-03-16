package com.ecommerce.product.infrastructure.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ProductRequestDto(

        @NotBlank(message = "Name must not be empty")
        String name,

        @Length(min = 10, max = 250, message = "Description must be between 10 and 250 characters")
        String description,

        @DecimalMin(value = "0.99", message = "Price must be greater than or equal to 0.99€")
        Double price,

        String image
) {
}