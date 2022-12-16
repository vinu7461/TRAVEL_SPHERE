package com.travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.exception.CustomerException;
import com.travel.exception.PackageException;
import com.travel.model.Admin;
import com.travel.model.Booking;
import com.travel.model.Customer;
import com.travel.model.Ticket;
import com.travel.service.AdminService;
import com.travel.service.BookingService;
import com.travel.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/Customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
	
		
		Customer saveCustomer=customerService.createCustomer(customer);
		
		
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/Bookings/{packid}")
	public ResponseEntity<Ticket> createBooking(@Valid @RequestBody Booking booking,@PathVariable("packid")Integer packageId) throws CustomerException, PackageException{
	
		
		Ticket saveBooking=bookingService.createBooking(booking, packageId);
		
		
		return new ResponseEntity<Ticket>(saveBooking,HttpStatus.CREATED);
		
	}

}
