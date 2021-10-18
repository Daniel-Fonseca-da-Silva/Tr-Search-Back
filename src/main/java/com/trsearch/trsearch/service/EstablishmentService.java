package com.trsearch.trsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsearch.trsearch.model.Establishment;

@Service
public class EstablishmentService {
	
	@Autowired
	private EstablishmentRepository repo;
	
	public List<Establishment> getEstablishment() {
		return repo.findAll();
	}
	
}
