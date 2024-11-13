package com.siemens.registrationapi.exceptions;

public class UserAccountNullException extends RuntimeException{
    public UserAccountNullException(String message) {
        super(message);
    }
}
