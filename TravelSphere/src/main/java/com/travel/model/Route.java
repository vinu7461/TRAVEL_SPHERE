package com.travel.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
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
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String dropPoint;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bus> bus= new ArrayList<>();
	
	
	
	
	
	
	
	

	
	
	
	

}
