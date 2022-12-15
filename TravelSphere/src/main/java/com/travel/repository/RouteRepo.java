package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.model.Route;

@Repository
public interface RouteRepo extends  JpaRepository<Route, Integer>{

	
	@Query("from Route where routeFrom=?1 And routeTo=?2 And dateOfJourney=?3")
	public Route findRoute(String routeFrom,String routeTo,String dateOfJourney);
	
}
