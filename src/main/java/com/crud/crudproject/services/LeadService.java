package com.crud.crudproject.services;

import java.util.List;

import com.crud.crudproject.entities.Lead;



public interface LeadService {

	Lead saveOneLead(Lead lead);

	List<Lead> listAllLeads();
	
	Lead getLeadById(Long id);
	
	Lead updateLead(Lead lead);
	
	void deleteById(Long id);
	
}
