package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String hotelName;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private  String hotelDescription;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private  String hotelAddress;
	
	
	private Integer avilableRooms;
	
	private String hotelType;
	
	
	
}
