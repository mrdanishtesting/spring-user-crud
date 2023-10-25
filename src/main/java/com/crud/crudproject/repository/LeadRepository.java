package com.crud.crudproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudproject.model.Lead;

public interface LeadRepository extends JpaRepository<Lead ,Long>{
    Optional<Lead> findByEmail(String email);
    Optional<Lead> findByUsernameOrEmail(String username, String email);
    Optional<Lead> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
