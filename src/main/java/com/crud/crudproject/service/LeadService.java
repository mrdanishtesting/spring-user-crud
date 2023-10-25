package com.crud.crudproject.service;

import org.springframework.http.ResponseEntity;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.dto.RestResponse;

public interface LeadService {

	ResponseEntity<RestResponse> saveOneLead(LeadDto leadDto);

	ResponseEntity<RestResponse> listLeads(int pageNum,int pageSize);

	ResponseEntity<RestResponse> getLeadById(long id);

	ResponseEntity<RestResponse> updateLead(LeadDto leadDto,long id);

	void deleteById(long id);

}
