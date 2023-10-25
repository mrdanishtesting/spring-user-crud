package com.crud.crudproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.crudproject.model.Lead;
import com.crud.crudproject.service.LeadService;

import io.swagger.annotations.Api;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

//	@Value("${spring.application.name}")
//	String appName;

	// http://localhost:4321/login
	@GetMapping("/login")
	public String showView(Model model) {
//		model.addAttribute("appName", appName);
		return "login";

	}

	@PostMapping("/save/leads")
	public String saveLead(@Valid @ModelAttribute("lead") Lead lead, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("result");

			return "create_lead";
		}
		// leadService.saveOneLead(lead);
		return "redirect:/listleads";
	}

	// http://localhost:8181/listleads
	// http://localhost:8181/api/listleads
//	@GetMapping("/listleads")
//	public String listLeads(Model model) {
//		model.addAttribute("listleads", leadService.listLeads());
//		return "list_leads";
//
//	}

	// http://localhost:8181/new/leads
	@GetMapping("/new/leads")
	public String createLeadForm(Model model) {
		model.addAttribute("lead", new Lead());
		return "create_lead";
	}

	// http://localhost:8181/leads/edit/{id}
	@GetMapping("/leads/edit/{id}")
	public String editLeadForm(@PathVariable Long id, Model model) {
		model.addAttribute("lead", leadService.getLeadById(id));
		return "update_lead";
	}

	// http://localhost:8181/update/leads/{id}
	/*
	 * @PostMapping("/update/leads/{id}") public String updateLead(@PathVariable
	 * Long id, @ModelAttribute("l") Lead lead, Model model) { Lead leadByID =
	 * leadService.getLeadById(id);
	 * 
	 * leadByID.setEmail(lead.getEmail()); leadByID.setPassword(lead.getPassword());
	 * leadByID.setConfirmPassword(lead.getConfirmPassword());
	 * leadByID.setDateOfBirth(lead.getDateOfBirth());
	 * leadByID.setCountry(lead.getCountry()); leadService.updateLead(leadByID);
	 * return "redirect:/listleads"; }
	 */

	// http://localhost:8181/show/delete/{id}
	@GetMapping("/show/delete/{id}")
	public String deletePage(@PathVariable Long id, Model model) {
		model.addAttribute("lead", leadService.getLeadById(id));
		return "delete_lead";
	}

	@GetMapping("/delete/leads/{id}")
	public String deleteLead(@PathVariable Long id) {
		leadService.deleteById(id);
		return "redirect:/listleads";
	}

}
