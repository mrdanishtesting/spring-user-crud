package com.crud.crudproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudproject.model.Lead;

public interface LeadRepository extends JpaRepository<Lead ,Long>{
	Optional<Lead> findByUsernameOrEmail(String username, String email);
}
