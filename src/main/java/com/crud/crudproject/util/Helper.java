package com.crud.crudproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.crud.crudproject.dto.LeadDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Helper {
	@Autowired
	private MessageSource messageSource;
	
	public boolean isAnyFieldEmptyInUser(LeadDto leadDto) {
		if (!StringUtils.hasText(leadDto.getEmail())
				|| !StringUtils.hasText(leadDto.getConfirmPassword()) || !StringUtils.hasText(leadDto.getPassword())
				|| !StringUtils.hasText(leadDto.getCountry()))
			return true;
		return false;
	
			

		
	}

	public String message(String messageType) {
		return messageSource.getMessage(messageType, null, null);
	}
	
	

		
	
		
		
		
	
}
