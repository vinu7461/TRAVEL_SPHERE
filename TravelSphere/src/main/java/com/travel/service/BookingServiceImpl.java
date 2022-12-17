package com.travel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.BookingException;
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
		
		if(existingPackage.getAvailableSeats()<booking.getMember()) throw new PackageException("available seats are less than required ");
		
		existingPackage.setAvailableSeats(existingPackage.getAvailableSeats()-booking.getMember());
		
		booking.setPackageDetails(existingPackage);
		
		Optional<Customer> opt1= customerRepo.findById(booking.getCustomerId());
		
		Customer existingCustomer=opt1.get();
		
		booking.setCustomer(existingCustomer);

		existingCustomer.getBookinglist().add(booking);
		
		Booking saveBooking=bookingRepo.save(booking);
		
		Ticket newTicket=new Ticket();
		
		newTicket.setDateOfJourney(existingPackage.getJourneyDate());


		newTicket.setBookingId(saveBooking.getBookingId());
		
		newTicket.setBusNumber(existingPackage.getBus().getBusNumber());
		
		newTicket.setMembers(saveBooking.getMember());
		
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




	@Override
	public Booking viewBooking(Integer bookingId) throws BookingException {
	
	Customer customer  =  new Customer();   // wehave to remove this	
	
    Booking booking= bookingRepo.findByCustomerIdAndBookingId(customer.getUserId(), bookingId);
	
	
	         if(booking==null) throw new BookingException("Booking not available with id"+bookingId); 
	        	 
	        	 return booking;
	        	 
	    
	}




	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		// TODO Auto-generated method stub
		
		Customer customer  =  new Customer();
		
		List<Booking> allBookings=customer.getBookinglist();
		
		if(allBookings.size()==0) throw new BookingException("Booking not available");
		
		return allBookings;
	}

	
	
}
