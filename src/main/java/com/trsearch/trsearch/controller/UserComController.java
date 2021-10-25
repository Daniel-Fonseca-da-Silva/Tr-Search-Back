package com.trsearch.trsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trsearch.trsearch.service.UserComService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/v1/usercom")
public class UserComController {
	
	@Autowired
	UserComService service;
	
}
