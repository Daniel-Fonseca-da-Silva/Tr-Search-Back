package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {

    Establishment findByCategory(Category category);

    Establishment findElementByName(String name);

    Establishment findByCode(String code);

    @Query("SELECT e FROM Establishment e JOIN e.corporateUser c WHERE c.id = :corporateUserId")
    List<Establishment> findElementsByCorporateUser(UUID corporateUserId);
}
