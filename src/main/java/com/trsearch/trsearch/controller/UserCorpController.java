package com.trsearch.trsearch.controller;

import java.util.Optional;

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

		return userCorp.map(corp -> ResponseEntity.ok(userCorp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public void createUserCorp(@RequestBody UserCorp userCorp) {
		service.createUserCorp(userCorp);
	}

	@PutMapping("/{id}")
	public void updateUserCorp(@PathVariable("id") Long id, @RequestBody UserCorp userCorp) {
		userCorp = service.updateUserCorp(userCorp, id);

	}

	@DeleteMapping("/{id}")
	public void deleteUserCorp(@PathVariable("id") Long id) {
		service.deleteUserCorp(id);
	}

}
