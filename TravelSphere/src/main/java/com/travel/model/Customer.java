package com.travel.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Mobile Number start with 6,7,8,9 and must be 10 digit")
	private String mobile;
	
	@Pattern(regexp = "[A-Za-z0-9@]{6,15}")
	private String password;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Booking> bookinglist= new ArrayList<>();
	
	
	
	
}
