package com.travel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.security.auth.kerberos.KerberosTicket;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.util.RouteMatcher.Route;

import lombok.Data;

@Entity
@Data
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String packageName;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String source;

	@NotBlank
	@NotEmpty
	@NotNull
	private String destination;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String packageType;
	
	@Min(1000)
	private Double packageCost;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private  String paymentMode="online";
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel hotel;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket ticket ;
	

}
