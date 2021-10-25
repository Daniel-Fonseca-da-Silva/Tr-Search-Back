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

	public UserCom updateUseCom(UserCom userCom, Long id) {
		Optional<UserCom> userCmSaved = getUserComById(id);
		if(userCmSaved.isPresent()) {
			UserCom usercomDB = userCmSaved.get();
			usercomDB.setBirthdayCom(userCom.getBirthdayCom());
			usercomDB.setCpfCom(userCom.getCpfCom());
			usercomDB.setEmailCom(userCom.getEmailCom());
			usercomDB.setGenderCom(userCom.getGenderCom());
			usercomDB.setLoginCom(userCom.getLoginCom());
			usercomDB.setNameCom(userCom.getNameCom());
			
			repo.save(usercomDB);
			return usercomDB;
		} else {
			return null;
		}
	}
	
}
