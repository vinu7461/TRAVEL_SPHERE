package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Bus;
import com.travel.model.Travel;
import java.util.*;
@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {
     
//	public Bus findByBusNumber(String busNumber);
	
	public List<Bus> findByJourneyDateAndBusFromAndBusTo(String journeyDate,String busFrom,String busTo);
	
	
	public List<Bus> findByBusFromAndBusTo(String busFrom,String busTo);


	
}
