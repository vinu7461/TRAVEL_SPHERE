package com.travel.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Route {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String routeFrom;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String routeTo;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String dateOfJourney;
	

	@NotBlank
	@NotEmpty
	@NotNull
	private String departureTime;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String arrivalTime;
	
	
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String pickUpPoint;
	
	private String packageType;
	@Min(1000)
	private Double packageCost;
	
	private  String paymentMode="online";
	
	
	

}
