package com.trsearch.trsearch.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trsearch.trsearch.model.UserCorp;

public interface UserCorpRepository extends JpaRepository<UserCorp, Long>{

    UserCorp findByLoginCorp(String loginCorp);

}
