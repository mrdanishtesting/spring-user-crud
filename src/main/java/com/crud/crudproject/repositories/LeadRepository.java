package com.crud.crudproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudproject.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead ,Integer>{

}
