package com.travel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busNumber;
	
	private Integer capacity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Travel travel;
	
	
}
