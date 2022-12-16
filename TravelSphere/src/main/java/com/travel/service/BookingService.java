package com.travel.service;

import com.travel.exception.PackageException;
import com.travel.model.Booking;
import com.travel.model.Ticket;

public interface BookingService {

	public Ticket createBooking(Booking boooking, Integer packageId) throws PackageException;
}
