package com.crud.crudproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.entities.Lead;



public interface LeadService {

	ResponseEntity<RestResponse> saveOneLead(Lead lead);

	List<Lead> listAllLeads();
	
	Lead getLeadById(Long id);
	
	Lead updateLead(Lead lead);
	
	void deleteById(Long id);
	
}
