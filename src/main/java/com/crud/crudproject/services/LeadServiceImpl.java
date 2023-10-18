package com.crud.crudproject.services;

import static com.crud.crudproject.util.MessageProperty.INFO_GLOBAL_SUCCESS_MESSAGE;
import static com.crud.crudproject.util.MessageProperty.INFO_LEAD_UPDATED_SUCCESS;
import static com.crud.crudproject.util.MessageProperty.INFO_USER_CREATED;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.crud.crudproject.dao.Dao;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.repositories.LeadRepository;
import com.crud.crudproject.util.Helper;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	Dao dao;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	Helper helper;

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public ResponseEntity<RestResponse> listLeads() {
		RestResponse response = new RestResponse();
		List<Lead> listAllLeads = dao.listAllLeads();
		List<LeadDto> leadDto = (List<LeadDto>) modelMapper.map(listAllLeads, List.class);
		response.setData(leadDto);
		response.setStatus(true);
		response.setMessage("list of all leads");
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> saveOneLead(LeadDto leadDto) {
		RestResponse response = new RestResponse();
		Lead lead = modelMapper.map(leadDto, Lead.class);
		Lead leadEntity = dao.createUser(lead);
		LeadDto dto = modelMapper.map(leadEntity, LeadDto.class);
		response.setData(dto);
		response.setStatus(true);
		response.setMessage(helper.message(INFO_USER_CREATED));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> getLeadById(Long id) {
		RestResponse response = new RestResponse();
		Lead viewOneLead = dao.viewOneLead(id);
		LeadDto dto = modelMapper.map(viewOneLead, LeadDto.class);
		response.setData(dto);
		response.setStatus(true);
		response.setMessage(helper.message(INFO_GLOBAL_SUCCESS_MESSAGE));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> updateLead(LeadDto leadDto) {
		RestResponse response = new RestResponse();
		Lead lead = modelMapper.map(leadDto, Lead.class);
		Lead updateLead = dao.updateLead(lead);
		LeadDto dto = modelMapper.map(updateLead, LeadDto.class);
		response.setStatus(true);
		response.setData(dto);
		response.setMessage(helper.message(INFO_LEAD_UPDATED_SUCCESS));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public void deleteById(Long id) {
		leadRepository.deleteById(id);

	}

}
