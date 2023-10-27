package com.crud.crudproject.controller;

import static com.crud.crudproject.util.MessagePropertyConstants.ERROR_USER_CREATE_FIELD_MISSING;
import static com.crud.crudproject.util.MessagePropertyConstants.INFO_LEAD_DELETED_SUCCESS;
import static com.crud.crudproject.util.MessagePropertyConstants.ERROR_USER_NOT_FOUND;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudproject.dto.JsonViews;
import com.crud.crudproject.dto.LeadDto;
import com.crud.crudproject.dto.RestResponse;
import com.crud.crudproject.model.Lead;
import com.crud.crudproject.repository.LeadRepository;
import com.crud.crudproject.service.LeadService;
import com.crud.crudproject.service.LeadServiceImpl;
import com.crud.crudproject.util.Helper;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/leads")
@Api(tags = "Leads")//
public class LeadRestController {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	LeadRepository leadRepo;

	@Autowired
	LeadService leadService;

	@Autowired
	Helper helper;

	
	// http://localhost:8181/api/leads
	@GetMapping
	@ApiOperation(value = "showing all the list of leads")
	public ResponseEntity<RestResponse> listAllLead(
			 
			@RequestParam(value="pageNum",defaultValue = "0",required = false) int pageNum,
			@RequestParam(value="pageSize",defaultValue = "0",required = false) int pageSize
			){
		
		
		
		return leadService.listLeads(pageNum,pageSize);

	}                                       

	@ApiOperation(value = "giving service to lead just by adding  a lead-info  ")
   // @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<RestResponse> createUser(@RequestBody @JsonView(JsonViews.Lead.class)LeadDto leadDto) {
		RestResponse restResponse = new RestResponse();
		if (!helper.isAnyFieldEmptyInUser(leadDto)) {
			return leadService.saveOneLead(leadDto);
		} else {
			restResponse.setStatus(false);
			restResponse.setMessage(helper.message(ERROR_USER_CREATE_FIELD_MISSING));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restResponse);
		}

	}

	@ApiOperation(value = "giving service to  find the lead onbehalf of lead-id ")
	@GetMapping("/find/lead/{id}")
	public ResponseEntity<RestResponse> findOneLead(@PathVariable("id") long id) {
			return leadService.getLeadById(id);

	}

	@ApiOperation(value = "giving service to update the lead")
	@PutMapping("/update/lead/{id}")
	public ResponseEntity<RestResponse> updateLead(@RequestBody @JsonView(JsonViews.Lead.Update.class) LeadDto leadDto,@PathVariable("id") long id) {
		return leadService.updateLead(leadDto,id);

	}

	// http://localhost:8181/api/leads/delete/id
	@ApiOperation(value = "deleting the lead ")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<RestResponse> deleteOneLead(@PathVariable(name="id") long id) {
		RestResponse response=new RestResponse();
		leadService.deleteById(id);
		response.setStatus(true);
		response.setMessage(helper.message(INFO_LEAD_DELETED_SUCCESS));
		//return new ResponseEntity<>("deleted the lead successfully",HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
