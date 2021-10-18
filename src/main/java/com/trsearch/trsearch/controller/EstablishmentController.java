package com.trsearch.trsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsearch.trsearch.model.Establishment;
import com.trsearch.trsearch.service.EstablishmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/establishment")
public class EstablishmentController {
	
	@Autowired
	EstablishmentService service;
	
	@GetMapping
	public List<Establishment> get() {
		return service.getEstablishment();
	}
	
	@GetMapping("/{id}")
	public Establishment getEstablishmentById(@PathVariable("id") Long id) {
		return service.getEstablishmentById(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Establishment>> establishmentName(@PathVariable("name") String name) {
		List<Establishment> establishments = service.establishmentName(name);
		return ResponseEntity.ok().body(establishments);
	}
	
}
