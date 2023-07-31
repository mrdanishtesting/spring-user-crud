package com.crud.crudproject.Services;

import com.crud.crudproject.entities.Lead;

public interface LeadService {

	public void saveOneLead(Lead lead);

	public boolean checkPassword(Lead lead);

	
}
