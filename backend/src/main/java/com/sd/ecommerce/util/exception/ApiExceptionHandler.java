package com.sd.ecommerce.util.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JsonInclude;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @SuppressWarnings("rawtypes")  // Suppress warnings about using raw types
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {

        ErrorResponse errorResponse = new ErrorResponse();

        for (ConstraintViolation violation : e.getConstraintViolations()) {
            ErrorItem errorItem = new ErrorItem();
            errorItem.setCode(violation.getMessageTemplate());
            errorItem.setMessage(violation.getMessage());
            errorResponse.addError(errorItem);
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")  // Suppress warnings about using raw types
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e) {
        ErrorItem errorItem = new ErrorItem();
        errorItem.setMessage(e.getMessage());

        return new ResponseEntity<>(errorItem, HttpStatus.NOT_FOUND);
    }

    public static class ErrorItem {
        
        @JsonInclude(JsonInclude.Include.NON_NULL) private String code;  // Ignore null values when serializing

        private String message; // Error message

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ErrorResponse {
        
        private List<ErrorItem> errors = new ArrayList<>();

        public List<ErrorItem> getErrors() {
            return errors;
        }

        public void setErrors(List<ErrorItem> errors) {
            this.errors = errors;
        }

        public void addError(ErrorItem error) {
            this.errors.add(error);
        }

    }
    
}
