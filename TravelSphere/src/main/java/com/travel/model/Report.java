package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Report_Id;
	
	@NotNull
	@NotEmpty
	@NotBlank
	String Report_Name;
	
	
	@NotNull
	@NotEmpty
	@NotBlank
	String Report_Type;
	
}
