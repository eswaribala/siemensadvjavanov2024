package com.siemens.registrationapi.exceptions;

import com.siemens.registrationapi.dtos.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // Add custom fields to the response
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
