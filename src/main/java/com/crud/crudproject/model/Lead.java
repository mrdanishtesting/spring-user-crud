package com.crud.crudproject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.crud.crudproject.dto.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "leads")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	@NotBlank(message = "email cannot be empty!!")

	
	private String name;
	private String username;
	@Column(name = "email", unique = true, length = 125)
	private String email;
	@NotBlank(message = "password cannot be empty!!")
	@Size(min = 3, message = "min length of character is 6")
	private String password;

	private String confirmPassword;

	@JsonView(JsonViews.Lead.Views.class)
	private String country;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "lead_roles", joinColumns = @JoinColumn(name = "lead_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	@JsonView(JsonViews.Lead.Views.class)
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

//	@Override
//	public String toString() {
//		return "Lead [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
//				+ ", dateOfBirth=" + dateOfBirth + ", country=" + country + "]";
//	}

}
