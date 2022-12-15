package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.AdminException;
import com.travel.exception.HotelException;
import com.travel.model.Admin;
import com.travel.model.Hotel;
import com.travel.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) throws HotelException {
		
		
	    Hotel existinghotel= hotelRepo.findByHotelName(hotel.getHotelName());
	  		  
	    if(existinghotel!=null) throw new HotelException("Hotel already Exists With this Name");

	    Hotel saveHotel=hotelRepo.save(hotel);
			   
			 
		return saveHotel;
	    }
				
	}

	
	

