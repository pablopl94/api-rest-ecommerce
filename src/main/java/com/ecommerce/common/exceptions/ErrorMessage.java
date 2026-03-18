package com.ecommerce.common.exceptions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {

    private String message;
    private String exception;
    private String path;
    private Map<String, String> errors;

    public ErrorMessage(String message, String exception, String path) {
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.errors = new HashMap<>();
    }

    public ErrorMessage(String message, String exception, String path, Map<String, String> erros) {
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.errors = erros;
    }
}
