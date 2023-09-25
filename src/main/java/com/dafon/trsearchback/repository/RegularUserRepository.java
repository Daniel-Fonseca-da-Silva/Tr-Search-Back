package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegularUserRepository extends JpaRepository<RegularUser, UUID> {


    UserDetails findByEmail(String email);
}
