package com.trsearch.trsearch.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
