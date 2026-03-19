package com.ecommerce.common.exceptions;

import com.ecommerce.product.domain.exception.InvalidFileException;
import com.ecommerce.product.domain.exception.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, MethodArgumentNotValidException exception) {
        log.warn("Validation error: {}", exception.getMessage());
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ErrorMessage(exception.getMessage(), exception.getClass().getSimpleName(), request.getRequestURI(), errors);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
        log.warn("Product not found: {}", exception.getMessage());
        return new ErrorMessage(exception.getMessage(), exception.getClass().getSimpleName(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFileException.class)
    @ResponseBody
    public ErrorMessage handleInvalidFile(HttpServletRequest request, InvalidFileException exception) {
        log.warn("Invalid file: {}", exception.getMessage());
        Map<String, String> errors = new HashMap<>();
        if (exception.getCause() != null) {
            errors.put("cause", exception.getCause().getMessage());
        }
        return new ErrorMessage(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                request.getRequestURI(),
                errors
        );
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorMessage handleGenericException(HttpServletRequest request, Exception exception) {
        log.error("Unexpected error", exception);
        return new ErrorMessage(
                "Internal server error",
                exception.getClass().getSimpleName(),
                request.getRequestURI()
        );
    }
}
