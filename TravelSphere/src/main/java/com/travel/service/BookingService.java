package com.travel.service;

import java.util.List;

import com.travel.exception.BookingException;
import com.travel.exception.LoginException;
import com.travel.exception.PackageException;
import com.travel.model.Booking;
import com.travel.model.Ticket;

public interface BookingService {

	public Ticket createBooking(Booking boooking, Integer packageId,String key) throws PackageException, LoginException;
	
	public Booking viewBooking(Integer bookingId,String key)throws BookingException, LoginException;
	
	public List<Booking> viewAllBooking(String key)throws BookingException, LoginException;
	
	public String cancelBooking(Integer bookingId,String key) throws LoginException, BookingException;
	
	
}
