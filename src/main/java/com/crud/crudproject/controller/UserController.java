package com.crud.crudproject.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Value("${spring.application.name}")
	String appName;
	
	
	//http://localhost:8081/login
	@RequestMapping("/login")
	public String viewPage(Model model) {
		model.addAttribute("appName", appName);
		return "login";
		
	}
	
	@GetMapping("/register")
    public String showForm(Model model) {
        Lead lead = new Lead();
        model.addAttribute("lead", lead);
        return "register";
    }
	
	@PostMapping("/register")
	public String saveLead(@ModelAttribute("Lead") Lead lead) {
	    leadService.saveOneLead(lead);
	    return "save";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String selection_Expression(Model model) {
		return "create";
	}
	
	
	
	
	
	
	
	

	
//http:localhost:8181/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model modell){
		 List<Lead> leads = leadService.listAllLeads();
		 modell.addAttribute("leads", leads);
		
		
		return "list_all";
	}
}
	
