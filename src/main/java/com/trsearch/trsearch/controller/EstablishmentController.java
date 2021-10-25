package com.trsearch.trsearch.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Establishment>> establishmentCategory(@PathVariable("category") String category) {
		List<Establishment> establishments = (List<Establishment>) service.establishmentCategory(category);
		return establishments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(establishments);
	}

	@GetMapping("/actived")
	public ResponseEntity<List<Establishment>> establishmentActived() {
		List<Establishment> establishments = service.establishmentActived();
		return ResponseEntity.ok().body(establishments);
	}

	@GetMapping("/deactivated")
	public ResponseEntity<List<Establishment>> establishmentDeactivated() {
		List<Establishment> establishments = service.establishmentDeactivated();
		return ResponseEntity.ok().body(establishments);
	}

	@PostMapping
	public ResponseEntity<Establishment> createEstablishment(@RequestBody Establishment establishment) {
		establishment = service.createEstablishment(establishment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(establishment.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEstablishment(@PathVariable Long id) {
		service.deleteEstablishment(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Establishment> updateEstablishment(@PathVariable Long id,
			@RequestBody Establishment establishment) {
		Establishment newEstablishment = service.updateEstablishment(id, establishment);
		return ResponseEntity.ok(newEstablishment);
	}

}
