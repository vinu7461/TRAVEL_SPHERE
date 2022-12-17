package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.AdminException;
import com.travel.exception.HotelException;
import com.travel.exception.LoginException;
import com.travel.model.Admin;
import com.travel.model.CurrentSession;
import com.travel.model.Hotel;
import com.travel.repository.HotelRepo;
import com.travel.repository.SessionRepo;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
	private HotelRepo hotelRepo;
    
    @Autowired
	private SessionRepo sessionRepo;
    
    
	
	@Override
	public Hotel createHotel(Hotel hotel,String key) throws HotelException, LoginException {
		
		
		
	    CurrentSession currentSession=	sessionRepo.findByUuid(key);
	    if(currentSession==null) throw new LoginException("Please enter valid key ");
	  
	  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
	    			
	    		
	    
	    		
	    	    	Hotel existinghotel= hotelRepo.findByHotelName(hotel.getHotelName());
	    	  		  
	    		    if(existinghotel!=null) throw new HotelException("Hotel already Exists With this Name");

	    		    Hotel saveHotel=hotelRepo.save(hotel);
	    				   
	    				 
	    			return saveHotel;
	    			
	    
	    }
				
	}

	
	

