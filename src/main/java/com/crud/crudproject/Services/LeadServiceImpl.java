package com.crud.crudproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);
		
	}

	@Override
	public boolean checkPassword(Lead lead) {
	return (lead.getPassword().equals(lead.getConfirmPassword()))?true:false ;
}
}
