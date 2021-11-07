package com.trsearch.trsearch.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

import com.trsearch.trsearch.model.UserCorp;
import com.trsearch.trsearch.service.UserCorpService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/usercorp")

public class UserCorpController {

	@Autowired
	UserCorpService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserCorpById(@PathVariable("id") Long id) {
		Optional<UserCorp> userCorp = service.getUserCorpById(id);
		return userCorp.isPresent() ? ResponseEntity.ok(userCorp) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> createUserCorp(@RequestBody UserCorp userCorp) {
		service.createUserCorp(userCorp);
		URI location = getUri(userCorp.getId());
		return ResponseEntity.created(location).build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserCorp(@PathVariable("id") Long id, @RequestBody UserCorp userCorp) {
		userCorp = service.updateUserCorp(userCorp, id);
		return userCorp != null ? ResponseEntity.ok(userCorp) : ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserCorp(@PathVariable("id") Long id) {
		boolean ok = service.deleteUserCorp(id);
		return ok ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

}
