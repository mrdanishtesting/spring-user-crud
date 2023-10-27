//package com.crud.crudproject.dto;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//public class SignUpDto {
//
//	@JsonView(value = { JsonViews.Lead.Views.class })
//	private String name;
//	@JsonView(value = { JsonViews.Lead.Views.class })
//	private String username;
//	@JsonView(value = { JsonViews.Lead.Views.class })
//	private String email;
//	@JsonView(value = { JsonViews.Lead.Views.class })
//	private String password;
//	
//	private String rolename = "ROLE_USER";
//
//	public SignUpDto() {
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getRolename() {
//		return rolename;
//	}
//
//	public void setRolename(String rolename) {
//		this.rolename = rolename;
//	}
//
//}
