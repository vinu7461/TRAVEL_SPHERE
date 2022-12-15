package com.travel.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Admin extends User {

	@NotBlank
	@NotEmpty
	@NotNull
	private String adminName;
	
	@Email
	private String email;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Mobile Number start with 6,7,8,9 and must be 10 digit")
	private String mobile;
	
	@Pattern(regexp = "[A-Za-z0-9@]{6,15}")
	private String password;
	
	
	
	
}
