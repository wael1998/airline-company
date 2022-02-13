package com.esprit.microservices.candidate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Pilote1Repository extends JpaRepository<Pilote1, Integer> {
	@Query("select c from Pilote1 c where c.nom like :nom")
	public Page<Pilote1> piloteByNom(@Param("nom") String n, Pageable pageable);
	   
}
