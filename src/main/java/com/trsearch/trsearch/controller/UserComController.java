package com.trsearch.trsearch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
