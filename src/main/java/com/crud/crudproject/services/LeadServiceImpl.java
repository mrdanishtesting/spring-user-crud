package com.crud.crudproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public List<Lead> listAllLeads() {
		return leadRepository.findAll();

	}

	@Override
	public Lead saveOneLead(Lead lead) {
		return leadRepository.save(lead);

	}

	@Override
	public Lead getLeadById(Long id) {
		Optional<Lead> leadOptional =  leadRepository.findById(id);
		
		if(leadOptional.isPresent()) {
			return leadOptional.get();
		}
		return null;
	}

	@Override
	public Lead updateLead(Lead lead) {
		return leadRepository.save(lead);

	}

	@Override
	public void deleteById(Long id) {
		leadRepository.deleteById(id);

	}
}
