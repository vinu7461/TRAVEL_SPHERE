package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.HotelException;
import com.travel.exception.TravelException;
import com.travel.model.Hotel;
import com.travel.model.Travel;
import com.travel.repository.HotelRepo;
import com.travel.repository.TravelRepo;
@Service
public class TravelServiceImpl implements TravelService {

	
	
	  @Autowired
		private TravelRepo travelRepo;
		
		@Override
		public Travel createTravel(Travel travel) throws TravelException {

			Travel savetravel=travelRepo.save(travel);
 
			return savetravel;
		 }

}
