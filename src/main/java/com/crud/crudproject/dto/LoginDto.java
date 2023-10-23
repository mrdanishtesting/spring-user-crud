package com.crud.crudproject.dto;

public class LoginDto {
	private String usernameOrEmail;
    private String password;   
    public LoginDto() {      }   
   
    public String getPassword() {      
        return password;   
    }   
    public void setPassword(String password) {      
        this.password = password;   
    
}

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	@Override
	public String toString() {
		return "LoginDto [usernameOrEmail=" + usernameOrEmail + ", password=" + password + "]";
	}
}