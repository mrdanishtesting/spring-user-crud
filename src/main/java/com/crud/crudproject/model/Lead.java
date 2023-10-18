package com.crud.crudproject.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "leads")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@NotBlank(message = "email cannot be empty!!")
	@Column(name = "email", unique = true, length = 125)
	
	private String email;
	@NotBlank(message = "password cannot be empty!!")
	@Size(min = 3, message = "min length of character is 6")
	private String password;
	
	private String confirmPassword;

	private Date dateOfBirth;
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

//	@Override
//	public String toString() {
//		return "Lead [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
//				+ ", dateOfBirth=" + dateOfBirth + ", country=" + country + "]";
//	}

}
