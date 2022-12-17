package com.travel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.BookingException;
import com.travel.exception.LoginException;
import com.travel.exception.PackageException;
import com.travel.model.Booking;
import com.travel.model.CurrentSession;
import com.travel.model.Customer;
import com.travel.model.Package;
import com.travel.model.Ticket;
import com.travel.repository.BookingRepo;
import com.travel.repository.CustomerRepo;
import com.travel.repository.PackageRepo;
import com.travel.repository.SessionRepo;
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
	
	@Autowired
	private SessionRepo sessionRepo; 
	
	
	

	@Override
	public Ticket createBooking(Booking booking,Integer packageId,String key) throws PackageException, LoginException {
		// TODO Auto-generated method stub
		
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("CUSTOMER")) throw new LoginException("LOGIN AS CUSTOMER"); 
		    			
		
		
		  	
		
		Optional<Package> opt=packageRepo.findById(packageId);
		
		if(opt.isPresent()) {
			
			
			
		Package existingPackage=opt.get();
		
		if(existingPackage.getAvailableSeats()<booking.getMember()) throw new PackageException("available seats are less than required ");
		
		existingPackage.setAvailableSeats(existingPackage.getAvailableSeats()-booking.getMember());
		
		booking.setPackageDetails(existingPackage);
		
		Optional<Customer> opt1= customerRepo.findById(booking.getCustomerId());
		
		Customer existingCustomer=opt1.get();
		
		booking.setBookingStatus("Conformed");
		
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
	public Booking viewBooking(Integer bookingId,String key) throws BookingException, LoginException {
	
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  

		    
	
	     Integer userId=currentSession.getUserId();
	
	
    Booking booking= bookingRepo.findByCustomerIdAndBookingId(userId, bookingId);
	
	
	         if(booking==null) throw new BookingException("Booking not available with id"+bookingId); 
	        	 
	        	 return booking;
	        	 
	    
	}




	@Override
	public List<Booking> viewAllBooking(String key) throws BookingException, LoginException {
		// TODO Auto-generated method stub
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");

		
	
		
		Integer userId=currentSession.getUserId();
		
		Optional<Customer> customer=customerRepo.findById(userId);
		
		
		List<Booking> allBookings=customer.get().getBookinglist();
		
		if(allBookings.size()==0) throw new BookingException("Booking not available");
		
		return allBookings;
	}




	@Override
	public String cancelBooking(Integer bookingId, String key) throws LoginException, BookingException {
	
		 
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("CUSTOMER")) throw new LoginException("LOGIN AS CUSTOMER"); 
		  	
		  	
			Integer userId=currentSession.getUserId();
			
			Customer customer=(customerRepo.findById(userId)).get();
			
			
		
			if(customer.getBookinglist().size()==0) throw new BookingException("Booking not available");
			
			List<Booking> bList=customer.getBookinglist();
			
			for(int i=0;i<bList.size();i++) {
				
				if(bList.get(i).getBookingId()==bookingId) {
					
					
					Booking booking	=(bookingRepo.findById(bookingId)).get();
					
					Integer packageSeats=booking.getPackageDetails().getAvailableSeats();
							
							packageSeats=packageSeats+booking.getMember();
							
							booking.getPackageDetails().setAvailableSeats(packageSeats);
					

							
							booking.setBookingStatus("Canceled");
							
					
						
					Ticket	ticket =ticketRepo.findByBookingId(bookingId);
					
					ticketRepo.deleteById(ticket.getTicketId());
					
					return "Booking Cancled";
					
				}
				
				
			}
			
		
		
		throw new BookingException("Booking not available with this id");
		
	}
	
	
	

	
	
}
