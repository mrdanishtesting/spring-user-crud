package com.crud.crudproject.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncodePassword {
	public static void main(String[] args) {
		PasswordEncoder encoderPassword = new BCryptPasswordEncoder();
		System.out.println(encoderPassword.encode("rohan"));
	}
}
