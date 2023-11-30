package com.dafon.trsearchback.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
public class TreatmentOfErrors {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(violation -> {
                    String propertyPath = violation.getPropertyPath().toString();
                    String message = violation.getMessage();
                    return propertyPath + " " + message;
                })
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Custom404Exception.class)
    public ResponseEntity<Object> handleCustom404Exception(Custom404Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Custom401Exception.class)
    public ResponseEntity<Object> handleCustom401Exception(Custom401Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treamentError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treamentError400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DatesErrorValidation::new).toList());
    }

    private record DatesErrorValidation(String field, String message) {
        public DatesErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
