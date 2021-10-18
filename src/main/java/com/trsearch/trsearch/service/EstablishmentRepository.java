package com.trsearch.trsearch.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trsearch.trsearch.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

	@Query("FROM Establishment WHERE name LIKE %?1%")
	List<Establishment> findByName(String name);
	
	Iterable<Establishment> findByCategory(String category);
	
}
