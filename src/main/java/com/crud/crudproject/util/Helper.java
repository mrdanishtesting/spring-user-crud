package com.crud.crudproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.model.Lead;


@Service
public class Helper {
	@Autowired
	private MessageSource messageSource;

	public boolean isAnyFieldEmptyInUser(LeadDto leadDto) {
		if (!StringUtils.hasText(leadDto.getEmail()) || !StringUtils.hasText(leadDto.getConfirmPassword())
				|| !StringUtils.hasText(leadDto.getPassword()) || !StringUtils.hasText(leadDto.getCountry()))
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
		
		
	}

