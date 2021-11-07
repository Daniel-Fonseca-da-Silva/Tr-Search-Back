package com.trsearch.trsearch.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trsearch.trsearch.model.Establishment;

import java.nio.file.AccessDeniedException;

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

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity accessDenied() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Access Denied"));
	}

	class Error {
		public String error;

		public Error(String error) {
			this.error = error;
		}
	}
}
