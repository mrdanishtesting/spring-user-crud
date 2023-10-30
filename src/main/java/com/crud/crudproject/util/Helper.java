package com.crud.crudproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.crud.crudproject.dto.JsonViews;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.model.Lead;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;


@Service
public class Helper {
	@Autowired
	private MessageSource messageSource;

	public boolean isAnyFieldEmptyInUser(LeadDto leadDto) {
		if (!StringUtils.hasText(leadDto.getEmail()) || !StringUtils.hasText(leadDto.getConfirmPassword())
				|| !StringUtils.hasText(leadDto.getPassword()) || !StringUtils.hasText(leadDto.getUsername())||!StringUtils.hasText(leadDto.getName()))
			return true;
		return false;

	}

	public String message(String messageType) {
		return messageSource.getMessage(messageType, null, null);
	}


	public boolean isNotInteger(String name) {
	    try {
	        Integer.parseInt(name);
	        return false; // It's an integer
	    } catch (NumberFormatException e) {
	        return true; // It's not an integer
	    }
	}

	public boolean isConfirmPassEqualsPassword(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	public boolean viewOneLead(Lead viewOneLead) {
		
		return false;
	}
		
	
	public JsonNode convertSingleNode(LeadDto leadDto) {
		
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		JsonNode node=null;
		
		try {
			String result = objectMapper.writerWithView((JsonViews.Lead.Views.class)).writeValueAsString(leadDto);
			node = objectMapper.readValue(result, JsonNode.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return node;
		
		
	}
		
	}

