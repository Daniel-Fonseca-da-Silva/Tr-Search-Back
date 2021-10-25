package com.trsearch.trsearch.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trsearch.trsearch.model.Establishment;

@RestControllerAdvice
public class ConfigException {
	
	@ExceptionHandler({ DataIntegrityViolationException.class })	
	public ResponseEntity<Establishment> errorIntegrityViolation(Exception e) {
		return ResponseEntity.status(400).build();
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Establishment> errorEmptyResultData(Exception e ) {
		return ResponseEntity.notFound().build();
	}
}
