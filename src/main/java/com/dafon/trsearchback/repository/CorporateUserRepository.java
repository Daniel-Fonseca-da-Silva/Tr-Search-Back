package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CorporateUserRepository extends JpaRepository<CorporateUser, UUID> {
    CorporateUser findByEmail(String email);
}
