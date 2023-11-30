package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    Optional<Address> findByRegularUserId(UUID id);

    Optional<Address> findByCorporateUserId(UUID id);

    Optional<Address> findByEstablishmentId(UUID id);
}
