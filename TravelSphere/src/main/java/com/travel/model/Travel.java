package com.travel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelId;
	
   private String travelName;
   
   @OneToMany(cascade = CascadeType.ALL)
   private List<Bus> busList=new ArrayList<>();

   
}
