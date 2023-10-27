package com.crud.crudproject.service;

import static com.crud.crudproject.util.MessagePropertyConstants.ERROR_USERNAME_INVALID;
import static com.crud.crudproject.util.MessagePropertyConstants.ERROR_USER_CONFIRM_PASSWORD_NOT_MATCHED;
import static com.crud.crudproject.util.MessagePropertyConstants.ERROR_USER_NOT_FOUND;
import static com.crud.crudproject.util.MessagePropertyConstants.INFO_GLOBAL_SUCCESS_MESSAGE;
import static com.crud.crudproject.util.MessagePropertyConstants.INFO_LEAD_UPDATED_SUCCESS;
import static com.crud.crudproject.util.MessagePropertyConstants.INFO_USER_CREATED;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.crudproject.dao.Dao;
import com.crud.crudproject.dto.JsonViews;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.model.Role;
import com.crud.crudproject.repository.RoleRepository;
import com.crud.crudproject.util.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	Dao dao;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	Helper helper;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<RestResponse> listLeads(int pageNum, int pageSize) {

		List<Lead> listAllLeads = dao.listAllLeads(pageNum, pageSize);
		List<LeadDto> leadDtoList = modelMapper.map(listAllLeads, List.class);
		// List<LeadDto> leadDto = modelMapper.map(listAllLeads, new
		// TypeToken<List<LeadDto>>() {}.getType());

		RestResponse response = new RestResponse();
//		JSONArray jsonArray;
		JsonNode node = convertToJsonNode(leadDtoList);

		response.setData(node);
		response.setStatus(true);
		response.setMessage(helper.message(INFO_GLOBAL_SUCCESS_MESSAGE));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> saveOneLead(LeadDto leadDto) {
		RestResponse response = new RestResponse();

		String name = leadDto.getName();
		String password = leadDto.getPassword();
		String confirmPassword = leadDto.getConfirmPassword();
		if (!helper.isNotInteger(name)) {
			// log.error(helper.message(ERROR_USERNAME_INVALID));
			response.setMessage(helper.message(ERROR_USERNAME_INVALID));

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		if (!helper.isConfirmPassEqualsPassword(password, confirmPassword)) {
			// log.error(helper.message(ERROR_USER_CONFIRM_PASSWORD_NOT_MATCHED));
			response.setMessage(helper.message(ERROR_USER_CONFIRM_PASSWORD_NOT_MATCHED));
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}

		Lead lead = modelMapper.map(leadDto, Lead.class);
		Role roles = roleRepository.findByName(leadDto.getRoles()).get();
		lead.setRoles(Collections.singleton(roles));
		Lead leadEntity = dao.createUser(lead);
		LeadDto dto = modelMapper.map(leadEntity, LeadDto.class);
		System.out.println(dto.toString());
		response.setData(dto);
		response.setStatus(true);
		response.setMessage(helper.message(INFO_USER_CREATED));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> getLeadById(long id) {
		RestResponse response = new RestResponse();

		Lead viewOneLead = dao.viewOneLead(id);
		if (viewOneLead != null) {
			LeadDto dto = modelMapper.map(viewOneLead, LeadDto.class);
			response.setData(dto);
			response.setStatus(true);
			response.setMessage(helper.message(INFO_GLOBAL_SUCCESS_MESSAGE));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		response.setMessage(helper.message(ERROR_USER_NOT_FOUND));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@Override
	public ResponseEntity<RestResponse> updateLead(LeadDto leadDto, long id) {
		RestResponse response = new RestResponse();
		Lead lead = dao.viewOneLead(id);

		// Lead newLead = modelMapper.map(leadDto, Lead.class);
		lead.setName(leadDto.getName());
		lead.setUsername(leadDto.getUsername());
		lead.setEmail(leadDto.getEmail());
		lead.setPassword(lead.getPassword());
		lead.setConfirmPassword(leadDto.getConfirmPassword());
		// lead.setRoles(leadDto.getRoles());
		Lead updateLead = dao.updateLead(lead);
		LeadDto dto = modelMapper.map(updateLead, LeadDto.class);
		response.setStatus(true);
		response.setData(dto);
		response.setMessage(helper.message(INFO_LEAD_UPDATED_SUCCESS));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public void deleteById(long id) {
		dao.deleteLead(id);
	}

	@SuppressWarnings("deprecation")
	private JsonNode convertToJsonNode(List<LeadDto> leadDtoList) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		JsonNode node = null;
		try {
			String result = objectMapper.writerWithView(JsonViews.Lead.Views.class).writeValueAsString(leadDtoList);
			System.out.println(result);
			node = objectMapper.readValue(result, JsonNode.class);

//			jsonArray = new JSONArray(objectMapper.writeValueAsString(activeDtoList));
		} catch (JsonProcessingException e) {
			// Handle the exception appropriately

		}
		return node;
	}

}
