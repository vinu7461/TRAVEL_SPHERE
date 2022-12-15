package com.travel.service;

import com.travel.exception.TravelException;
import com.travel.model.Travel;

public interface TravelService {
  
	public Travel createTravel(Travel travel) throws TravelException;
}
