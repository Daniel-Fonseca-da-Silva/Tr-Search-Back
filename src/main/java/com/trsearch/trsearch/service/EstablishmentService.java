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
	
	public List<Establishment> establishmentName(String name) {
		List<Establishment> establishments = repo.findByName(name);
		return establishments;
	}
	
	public Iterable<Establishment> establishmentCategory(String category) {
		return repo.findByCategory(category);
	}
	
	public List<Establishment> establishmentActived() {
		List<Establishment> establishments = repo.findByActived();
		return establishments;
	}
	
	public List<Establishment> establishmentDeactivated() {
		List<Establishment> establishments = repo.findByDeactivated();
		return establishments;
	}
	
	public Establishment createEstablishment(Establishment establishment) {
		establishment.setId(null);
		return repo.save(establishment);
	}
	
	public void deleteEstablishment(Long id) {
		repo.deleteById(id);
	}
	
}
