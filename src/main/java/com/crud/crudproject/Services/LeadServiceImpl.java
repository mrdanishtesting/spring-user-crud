package com.crud.crudproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;


@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead lead) {
		Lead save = leadRepo.save(lead);
		
	}

	@Override
	public boolean checkPassword(Lead lead) {
	return (lead.getPassword().equals(lead.getConfirmPassword()))?true:false ;
}

	@Override
	public List<Lead> listAllLeads() {
        List<Lead> leads = leadRepo.findAll();
        return leads;
	}
}
