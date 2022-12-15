package com.travel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busNumber;
	
	private Integer capacity;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String busFrom;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String busTo;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Travel travel;
	
	
}
