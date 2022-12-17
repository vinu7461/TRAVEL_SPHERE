package com.travel.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	
	private String dateOfJourney;
	
	private Integer bookingId;
	
	private Integer members;
	
	private Integer busNumber;
	
	private String source;
	
	private String destination;
	
	private String pickUpPoint;

	private String depatureTime;
	
	private String packageDetails;
	
	
	
	
	
	
	
	
	
}
