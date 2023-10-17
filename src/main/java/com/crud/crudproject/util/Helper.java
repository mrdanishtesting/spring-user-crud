package com.crud.crudproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.crud.crudproject.entities.Lead;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Helper {
	@Autowired
	private MessageSource messageSource;
	
	public boolean isAnyFieldEmptyInUser(Lead lead) {
		if (!StringUtils.hasText(lead.getEmail())
				|| !StringUtils.hasText(lead.getConfirmPassword()) || !StringUtils.hasText(lead.getPassword())
				|| !StringUtils.hasText(lead.getCountry()))
			return true;
		return false;
	
			

		
	}

	public String message(String messageType) {
		return messageSource.getMessage(messageType, null, null);
	}
}
