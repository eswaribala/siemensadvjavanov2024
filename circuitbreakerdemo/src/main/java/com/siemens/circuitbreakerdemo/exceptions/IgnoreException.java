package com.siemens.circuitbreakerdemo.exceptions;

public class IgnoreException  extends RuntimeException{

    public IgnoreException(String message) {
        super(message);
    }
}
