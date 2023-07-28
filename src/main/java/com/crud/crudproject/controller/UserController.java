package com.crud.crudproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	
	//http://localhost:9091/login
	@RequestMapping("/login")
	public String viewPage(Model model) {
		User user=new User(101,"mike","mike@gmail.com");
		model.addAttribute("user", user);
		return "login";
		
	}
	
	public String selection_Expression() {
		
		return "select-expression";
	}
}
