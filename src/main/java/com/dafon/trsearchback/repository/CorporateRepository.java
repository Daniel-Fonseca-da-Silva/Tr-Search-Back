package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface CorporateRepository extends JpaRepository<CorporateUser, UUID> {
    UserDetails findByEmail(String email);
}
