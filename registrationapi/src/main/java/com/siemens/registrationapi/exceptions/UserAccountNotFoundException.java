package com.siemens.registrationapi.exceptions;

public class UserAccountNotFoundException extends RuntimeException{
    public UserAccountNotFoundException(String message) {
        super(message);
    }
}
