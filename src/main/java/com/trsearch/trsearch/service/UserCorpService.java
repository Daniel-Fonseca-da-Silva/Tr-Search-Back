package com.trsearch.trsearch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trsearch.trsearch.model.UserCorp;

@Service
public class UserCorpService {

	@Autowired
	private UserCorpRepository repo;

	public Optional<UserCorp> getUserCorpById(Long id) {
		return repo.findById(id);
	}


}
