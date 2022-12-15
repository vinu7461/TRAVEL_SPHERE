package com.travel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelId;
	
	@NotNull
	@NotBlank
	@NotEmpty
    private String travelName;
   
   @OneToMany(cascade = CascadeType.ALL)
   private List<Bus> busList=new ArrayList<>();

   
}
