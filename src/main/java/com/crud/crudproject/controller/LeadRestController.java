package com.crud.crudproject.controller;



import java.util.List;
import static com.crud.crudproject.util.MessageProperty.ERROR_USER_CREATE_FIELD_MISSING;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;
import com.crud.crudproject.services.LeadService;
import com.crud.crudproject.util.Helper;

@RestController
@RequestMapping("api/leads")
public class LeadRestController {
	
	
	@Autowired
	LeadRepository leadRepo;

	@Autowired
	LeadService leadService;
	
	@Autowired
	Helper helper;

	// http://localhost:8181/api/leads
	@GetMapping
	public List<Lead> listAllLead() {
		List<Lead> listAllLeads = leadService.listAllLeads();
		return listAllLeads;

	}

	@PostMapping
	public ResponseEntity<RestResponse>  createUser(@RequestBody Lead lead) {
		RestResponse restResponse=new RestResponse();
		if (!helper.isAnyFieldEmptyInUser(lead)) {
			return leadService.saveOneLead(lead);
		} else {
			restResponse.setStatus(false);
			restResponse.setMessage(helper.message(ERROR_USER_CREATE_FIELD_MISSING));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restResponse);
		}
		
	}
		

	@GetMapping("/getOneLead/{id}")
	public Lead findOneLead(@PathVariable("id") long id) {
		Lead oneLead = leadService.getLeadById(id);
		return oneLead;

	}

	@PutMapping
	public Lead updateLead(@RequestBody Lead lead) {
		Lead updatedLead = leadService.updateLead(lead);
		return updatedLead;

	}

	// http://localhost:8181/api/leads/delete/id
	@DeleteMapping("delete/{id}")
	public void deleteOneLead(@PathVariable Long id) {
		leadService.deleteById(id);
	}

}
