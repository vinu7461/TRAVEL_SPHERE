package com.travel.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String bookingType="online";
	
	@NotBlank
	@NotEmpty
	@NotNull
	private LocalDateTime bookingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Package packageDetails;

	
}
