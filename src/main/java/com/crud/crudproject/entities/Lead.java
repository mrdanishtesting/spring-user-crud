package com.crud.crudproject.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Column(name="email",unique = true,length=125)
	private String email;
	@NotBlank(message = "password cannot be empty!!")
	@Size(min = 3,message = "min length of character is 6")
	private String password;
	private String confirmPassword;
	
	private Date dateOfBirth;
	private String country;
	
}
