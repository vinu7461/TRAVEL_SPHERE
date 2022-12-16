package com.travel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.PackageException;
import com.travel.model.Booking;
import com.travel.model.Customer;
import com.travel.model.Package;
import com.travel.model.Ticket;
import com.travel.repository.BookingRepo;
import com.travel.repository.CustomerRepo;
import com.travel.repository.PackageRepo;
import com.travel.repository.TicketRepo;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepo bookingRepo; 
	
	@Autowired
	private PackageRepo packageRepo; 
	
	@Autowired
	private CustomerRepo customerRepo; 
	
	@Autowired
	private TicketRepo ticketRepo; 
	
	
	

	@Override
	public Ticket createBooking(Booking booking,Integer packageId) throws PackageException {
		// TODO Auto-generated method stub
		
		Optional<Package> opt=packageRepo.findById(packageId);
		
		if(opt.isPresent()) {
			
		Package existingPackage=opt.get();
		
		booking.setPackageDetails(existingPackage);
		
		Optional<Customer>  opt1= customerRepo.findById(booking.getCustomrId());
		
		Customer existingCustomer=opt1.get();
		
		booking.setCustomer(existingCustomer);

		existingCustomer.getBookinglist().add(booking);
		
		Booking saveBooking=bookingRepo.save(booking);
		
		Ticket newTicket=new Ticket();
		
		newTicket.setDateOfJourney(existingPackage.getJourneyDate());


		newTicket.setBookingId(saveBooking.getBookingId());
		
		newTicket.setBusNumber(existingPackage.getBus().getBusNumber());
		
		newTicket.setSource(existingPackage.getSource());
		
		newTicket.setDestination(existingPackage.getDestination());
		
		newTicket.setPickUpPoint(existingPackage.getRoute().getPickUpPoint());
		
		newTicket.setDepatureTime(existingPackage.getRoute().getDepartureTime());
		
		newTicket.setPackageDetails("packageName :"+existingPackage.getPackageName()+ "----------"+
				"Hotel Name : "+existingPackage.getHotel().getHotelName()+ "------------"+
				"Hotel Address : "+existingPackage.getHotel().getHotelAddress()
				);
		
		return  ticketRepo.save(newTicket);
	    
			
		}else {
			throw new PackageException("Package not available with id"+packageId);
		}
		
		
		
	}

	
	
}
