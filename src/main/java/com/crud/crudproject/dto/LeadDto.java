package com.crud.crudproject.dto;

import com.crud.crudproject.util.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;
@JsonPropertyOrder({ "id","name","username", "email", "password", "confirmPassword" })
public class LeadDto {

	private long id;
	@JsonView(value = { JsonViews.Lead.class, JsonViews.Lead.Update.class,JsonViews.Lead.SignUp.class })
	@Schema(name = "name", example = "rahul", required = false)
	private String name;
	@JsonView(value = {   JsonViews.Lead.class, JsonViews.Lead.Update.class ,JsonViews.Lead.SignUp.class})
	@Schema(name = "username", example = "username", required = false)
	private String username;
	@JsonView(value = { JsonViews.Lead.class,JsonViews.Lead.Update.class ,JsonViews.Lead.SignUp.class})
	@Schema(name = "email", example = "rahul@gmail.com", required = false)
	private String email;
	@JsonView(value = { JsonViews.Lead.class, JsonViews.Lead.Update.class ,JsonViews.Lead.SignUp.class})
	@Schema(name = "password", example = "password", required = false)
	private String password;
	@JsonView(value = { JsonViews.Lead.class, JsonViews.Lead.Update.class ,JsonViews.Lead.SignUp.class})
	@Schema(name = "confirmPassword", example = "confirmPassword", required = false)
	private String confirmPassword;
	private String country;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String roles=UserRole.ROLE_USER;

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

	@Override
	public String toString() {
		return "LeadDto [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", country=" + country + ", roles=" + roles + "]";
	}

}
