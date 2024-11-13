package com.siemens.productapi.exceptions;

public class ProductInstanceNotAvailable extends RuntimeException{
    public ProductInstanceNotAvailable(String message) {
        super(message);
    }
}
