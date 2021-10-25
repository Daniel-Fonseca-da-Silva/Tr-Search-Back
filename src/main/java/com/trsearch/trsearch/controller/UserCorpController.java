package com.trsearch.trsearch.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsearch.trsearch.service.UserCorpService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/usercorp")

public class UserCorpController {
	
	UserCorpService service;
	
}
