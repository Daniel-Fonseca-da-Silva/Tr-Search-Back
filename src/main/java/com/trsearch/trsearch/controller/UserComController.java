package com.trsearch.trsearch.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trsearch.trsearch.model.UserCom;
import com.trsearch.trsearch.service.UserComService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/v1/usercom")
public class UserComController {

	@Autowired
	UserComService service;

	@GetMapping("/{id}")
	ResponseEntity<?> getUserComById(@PathVariable("id") Long id) {
		Optional<UserCom> userCom = service.getUserComById(id);
		return userCom.isPresent() ? ResponseEntity.ok(userCom) : ResponseEntity.notFound().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PostMapping
	public ResponseEntity<?> createUserCom(@RequestBody UserCom userCom) {
		service.createUseCom(userCom);
		URI location = getUri(userCom.getId());
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserCom(@PathVariable("id") Long id, @RequestBody UserCom userCom) {
		userCom = service.updateUseCom(userCom, id);
		return userCom != null ? ResponseEntity.ok(userCom) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserCom(@PathVariable("id") Long id) {
		boolean ok = service.deleteUserCom(id);
		return ok ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

}
