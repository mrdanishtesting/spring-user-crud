package com.crud.crudproject.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.repositories.LeadRepository;

@Component
public class Dao {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private LeadRepository leadRepository;

	public List<Lead> listAllLeads(int pageNum,int pageSize) {
Pageable pageable=PageRequest.of(pageNum, pageSize);
          Page<Lead> lead = leadRepository.findAll(pageable);
          List<Lead> list = lead.getContent();
		return list;

	}

	public Lead createUser(Lead lead) {
		Lead leadEntity = leadRepository.save(lead);
		return leadEntity;
	}

	public Lead viewOneLead(Long id) {
		Optional<Lead> leadOptional = leadRepository.findById(id);
		if (leadOptional.isPresent()) {
			return leadOptional.get();
		}
		return null;

	}

	public Lead updateLead(Lead lead) {
		return leadRepository.save(lead);

	}
}
