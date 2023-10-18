package com.crud.crudproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudproject.model.Lead;

public interface LeadRepository extends JpaRepository<Lead ,Long>{

}
