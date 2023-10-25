package com.crud.crudproject.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.crud.crudproject.dto.JsonViews;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.repository.LeadRepository;
import com.fasterxml.jackson.annotation.JsonView;

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

	public Lead createUser(@JsonView(JsonViews.Lead.Views.class) Lead lead) {
		Lead leadEntity = leadRepository.save(lead);
		return leadEntity;
	}

	public Lead viewOneLead(long id) {
		Optional<Lead> leadOptional = leadRepository.findById(id);
		if (leadOptional.isPresent()) {
			return leadOptional.get();
		}
		return null;

	}

	public Lead updateLead( Lead lead) {
		return leadRepository.save(lead);

	}

	public void deleteLead(long id) {
		leadRepository.deleteById(id);
		
	}
}
