package com.trsearch.trsearch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsearch.trsearch.model.UserCom;

@Service
public class UserComService {
	
	@Autowired
	UserComRepository repo;

	public Optional<UserCom> getUserComById(Long id) {
		return repo.findById(id);
	}

	public void createUseCom(UserCom userCom) {
		repo.save(userCom);
	}
	
}
