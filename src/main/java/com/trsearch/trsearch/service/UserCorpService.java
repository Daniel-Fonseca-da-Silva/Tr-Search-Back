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

	public void createUserCorp(UserCorp userCorp) {
		repo.save(userCorp);
	}

	public UserCorp updateUserCorp(UserCorp userCorp, Long id) {

		Optional<UserCorp> usercSaved = getUserCorpById(id);
		if (usercSaved.isPresent()) {
			UserCorp usercDB = usercSaved.get();
			usercDB.setNameCorp(userCorp.getNameCorp());
			usercDB.setLoginCorp(userCorp.getLoginCorp());
			usercDB.setPasswordCorp(userCorp.getPasswordCorp());
			usercDB.setCnpjCorp(userCorp.getCnpjCorp());
			usercDB.setEmailCorp(userCorp.getEmailCorp());

			repo.save(usercDB);
			return usercDB;
		} else {
			return null;
		}

	}

	public boolean deleteUserCorp(Long id) {
		Optional<UserCorp> userCorp = getUserCorpById(id);

		if (userCorp.isPresent()) {
			repo.deleteById(id);
			return true;
		} else
			return false;
	}

}
