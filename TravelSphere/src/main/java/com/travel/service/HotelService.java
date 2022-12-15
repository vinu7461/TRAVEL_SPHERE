package com.travel.service;

import com.travel.exception.HotelException;
import com.travel.model.Hotel;

public interface HotelService {
    
	
	public Hotel createHotel( Hotel hotel ) throws HotelException;
		

}
