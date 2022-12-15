package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Hotel;
import com.travel.model.Travel;
@Repository
public interface TravelRepo extends JpaRepository<Travel, Integer> {
 
	public Travel findByTravelName(String travelName);
}
