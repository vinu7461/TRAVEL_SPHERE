package com.travel.service;

import java.util.List;

import com.travel.exception.BookingException;
import com.travel.exception.PackageException;
import com.travel.model.Booking;
import com.travel.model.Ticket;

public interface BookingService {

	public Ticket createBooking(Booking boooking, Integer packageId) throws PackageException;
	
	public Booking viewBooking(Integer bookingId)throws BookingException;
	
	public List<Booking> viewAllBooking()throws BookingException;
	
	
}
