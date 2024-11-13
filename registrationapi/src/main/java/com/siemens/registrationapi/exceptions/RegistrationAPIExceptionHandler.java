package com.siemens.registrationapi.exceptions;

import com.siemens.registrationapi.dtos.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationAPIExceptionHandler {

    @ExceptionHandler(UserAccountNullException.class)
    public ResponseEntity<GenericResponse> handleUserAccountNullException(UserAccountNullException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<String>(ex.getMessage()));
    }
    @ExceptionHandler(UserAccountNotFoundException.class)
    public ResponseEntity<GenericResponse> handleUserAccountNotFoundException(UserAccountNotFoundException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse<String>(ex.getMessage()));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericResponse> handleAnyRunTimeException(RuntimeException ex){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<String>(ex.getMessage()));
    }


}
