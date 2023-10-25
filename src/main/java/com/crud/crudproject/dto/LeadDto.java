package com.crud.crudproject.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class LeadDto {

	
	private long id;
	@JsonView(value = { JsonViews.Lead.class ,JsonViews.Lead.Update.class})
	private String name;
	@JsonView(value = { JsonViews.Lead.class,JsonViews.Lead.Update.class })
	private String username;
	@JsonView(value = { JsonViews.Lead.class ,JsonViews.Lead.Update.class})
	private String email;
	@JsonView(value = { JsonViews.Lead.class,JsonViews.Lead.Update.class })
	private String password;
	@JsonView(value = { JsonViews.Lead.class,JsonViews.Lead.Update.class })
	private String confirmPassword;
	@JsonView(value = { JsonViews.Lead.class})
	private String country;
	@JsonView(value = { JsonViews.Lead.class})
	private String roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


	




}
