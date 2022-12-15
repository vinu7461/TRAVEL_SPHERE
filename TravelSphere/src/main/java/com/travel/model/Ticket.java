package com.travel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;
	
	
	
	
	
}
