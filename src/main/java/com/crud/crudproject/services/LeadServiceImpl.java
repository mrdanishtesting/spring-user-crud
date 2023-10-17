package com.crud.crudproject.services;
import static com.crud.crudproject.util.MessageProperty.INFO_USER_CREATED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;
import com.crud.crudproject.util.Helper;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	Helper helper ;

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public List<Lead> listAllLeads() {
		return leadRepository.findAll();

	}

	@Override
	public ResponseEntity<RestResponse> saveOneLead(Lead lead) {
		RestResponse response =new RestResponse();
	Lead save = leadRepository.save(lead);
	response.setStatus(true);
	response.setMessage(helper.message(INFO_USER_CREATED));
	return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
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
