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
public class Customer extends User {

	@NotBlank
	@NotEmpty
	@NotNull
	private String customerName;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String address;
	
	@Email
	private String email;
	
	@Pattern(regexp = "[7,8,9]{1}[0-9]{9}")
	private String mobile;
	
	@Pattern(regexp = "[A-Za-z0-9@]{6,15}")
	private String password;
	
	
	
	
}
