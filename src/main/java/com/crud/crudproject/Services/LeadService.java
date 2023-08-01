package com.crud.crudproject.Services;

import java.util.List;

import com.crud.crudproject.entities.Lead;



public interface LeadService {

	public void saveOneLead(Lead lead);

	public boolean checkPassword(Lead lead);
    
	public List<Lead> listAllLeads();
	
}
