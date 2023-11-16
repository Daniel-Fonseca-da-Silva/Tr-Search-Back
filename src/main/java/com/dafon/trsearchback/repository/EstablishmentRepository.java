package com.dafon.trsearchback.repository;

import com.dafon.trsearchback.model.Category;
import com.dafon.trsearchback.model.Establishment;

import com.dafon.trsearchback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {

    Establishment findByCategory(Category category);

    Establishment findElementByName(String name);

    Establishment findByCode(String code);
}
