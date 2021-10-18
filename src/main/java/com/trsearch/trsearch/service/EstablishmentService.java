package com.trsearch.trsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsearch.trsearch.exception.ObjectNotFoundException;
import com.trsearch.trsearch.model.Establishment;

@Service
public class EstablishmentService {
	
	@Autowired
	private EstablishmentRepository repo;
	
	public List<Establishment> getEstablishment() {
		return repo.findAll();
	}
	
	public Establishment getEstablishmentById(Long id) {
		Optional<Establishment> establishment = repo.findById(id);
		return establishment.orElseThrow(() -> new ObjectNotFoundException(
				"Don't possible to find this establishment! id: " + "type: " + Establishment.class.getName()));
	}
	
}
