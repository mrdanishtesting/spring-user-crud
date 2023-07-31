package com.crud.crudproject.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.crudproject.Services.LeadService;
import com.crud.crudproject.dto.LeadData;
import com.crud.crudproject.entities.Lead;



@Controller
public class UserController {

	@Autowired
	private LeadService leadService;
	
	
	//http://localhost:9091/login
	@RequestMapping("/login")
	public String viewPage(Model model) {
		User user=new User(101,"mike","mike@gmail.com");
		model.addAttribute("user", user);
		return "login";
		
	}
	
	//http
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String selection_Expression() {
		 
		return "create";
	}
	
	
//	@RequestMapping(value="/save",method=RequestMethod.POST)
//	public String saveLead(@ModelAttribute Lead lead,Model model) {
//		leadService.saveOneLead(lead);
//		leadService.checkPassword(lead);
//		if(true) {
//			model.addAttribute("status", "record saved");
//			return "showlead";
//		}
//		else {
//			model.addAttribute("status","confirmpassword&passwordAreNotSame");
//			return "create";
//		}
//		
//	}

//	@RequestMapping("/save")
//	public String saveLead(@RequestParam("email")String userEmail ,@RequestParam("password") String userpassword ,@RequestParam("confirmPassword") String repassword ,@RequestParam("dateOfBirth") Date dateofbirth ,@RequestParam("country") String country ,Lead lead ) {
//		leadService.saveOneLead(lead);
//		
//		System.out.println("save");
//		return "showlead";
//	}
//	
	@RequestMapping("/save")
	public String saveLead(LeadData leaddata) {
		
		Lead lead=new Lead();
		lead.setId(leaddata.getId());
		lead.setEmail(leaddata.getEmail());
		lead.setPassword(leaddata.getPassword());
		lead.setConfirmPassword(leaddata.getConfirmPassword());
		lead.setDateOfBirth(leaddata.getDateOfBirth());
		lead.setCountry(leaddata.getCountry());
		leadService.saveOneLead(lead);
		
		return "showlead";
	}
}
