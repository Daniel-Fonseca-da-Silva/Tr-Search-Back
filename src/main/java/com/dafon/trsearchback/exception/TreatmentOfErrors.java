package com.dafon.trsearchback.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class TreatmentOfErrors {


    @ExceptionHandler(Custom404Exception.class)
    public ResponseEntity<Object> handleCustom404Exception(Custom404Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
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
