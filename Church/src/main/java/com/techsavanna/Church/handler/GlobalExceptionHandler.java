package com.techsavanna.Church.handler;

import com.techsavanna.Church.responses.ApiResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle custom ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>("error", ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle type mismatch in request parameters
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid value for parameter: " + ex.getName();
        ApiResponse<String> response = new ApiResponse<>("error", message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle deletion of non-existent record
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ApiResponse<String>> handleEmptyResult(EmptyResultDataAccessException ex) {
        ApiResponse<String> response = new ApiResponse<>("error", "No record found to delete", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Catch-all for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGlobalException(Exception ex) {
        ApiResponse<String> response = new ApiResponse<>("error", "An unexpected error occurred", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
