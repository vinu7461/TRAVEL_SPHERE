package com.travel.service;

import java.util.List;

import com.travel.exception.LoginException;
import com.travel.exception.TravelException;
import com.travel.model.Travel;

public interface TravelService {
  
	public Travel createTravel(Travel travel,String key) throws TravelException, LoginException;

   public List<Travel> ViewTravel(String key)throws TravelException, LoginException;
	
	public Travel updateTravel(Travel travel,String key)throws TravelException, LoginException;
	
	public Travel getTravel(Integer Id,String key)throws TravelException, LoginException;
}
