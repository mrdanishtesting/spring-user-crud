package com.crud.crudproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudproject.entities.Lead;
import com.crud.crudproject.repositories.LeadRepository;


@RestController
@RequestMapping("api/leads")
public class LeadRestController {
     
	@Autowired
	LeadRepository leadRepo;
	
	//http://localhost:8181/api/leads
	@GetMapping
	public List<Lead> listAllLead(){
		return leadRepo.findAll();
	}
	
	@PostMapping
	public Lead saveOneLead(@RequestBody Lead lead) {
		return leadRepo.save(lead);
		
	}
	
	@PutMapping
	public Lead updateOneLead(@RequestBody Lead lead) {
		return leadRepo.save(lead);
	}
	
	//http://localhost:8181/api/leads/delete/id
	@DeleteMapping("delete/{id}")
	public void deleteOneLead(@PathVariable Long id) {
		leadRepo.deleteById(id);
	}
	
}
