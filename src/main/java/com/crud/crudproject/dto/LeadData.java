package com.crud.crudproject.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class LeadData {

	private int id;
	private String email;
	private String password;
	private String confirmPassword;
	private Date dateOfBirth;
	private String country;
}
