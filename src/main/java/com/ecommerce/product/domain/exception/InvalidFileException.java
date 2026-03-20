package com.ecommerce.product.domain.exception;

public class InvalidFileException extends RuntimeException {

    public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
