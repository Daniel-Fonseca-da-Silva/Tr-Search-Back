package com.trsearch.trsearch.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trsearch.trsearch.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	
}
