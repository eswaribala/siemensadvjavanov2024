package com.siemens.productapi.exceptions;

public class ProductNotAvailable extends RuntimeException{
    public ProductNotAvailable(String message) {
        super(message);
    }
}
