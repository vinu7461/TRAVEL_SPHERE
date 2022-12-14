package com.travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.exception.BookingException;
import com.travel.exception.CustomerException;
import com.travel.exception.LoginException;
import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.model.Admin;
import com.travel.model.Booking;
import com.travel.model.Customer;
import com.travel.model.Package;
import com.travel.model.Route;
import com.travel.model.Ticket;
import com.travel.service.AdminService;
import com.travel.service.BookingService;
import com.travel.service.CustomerService;
import com.travel.service.PackageService;
import com.travel.service.RouteService;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private PackageService packageService;
	
	
	@PostMapping("/Customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
	
		
		Customer saveCustomer=customerService.createCustomer(customer);
		
		
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/Bookings/{packid}/{key}")
	public ResponseEntity<Ticket> createBooking(@Valid @RequestBody Booking booking,@PathVariable("packid")Integer packageId,@PathVariable("key") String key) throws CustomerException, PackageException, LoginException{
	
		
		Ticket saveBooking=bookingService.createBooking(booking, packageId,key);
		
		
		return new ResponseEntity<Ticket>(saveBooking,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Bookings/{key}")
	public ResponseEntity<List<Booking>> viewAllBooking( @PathVariable("key") String key) throws BookingException, LoginException  {
	
		
		List<Booking> saveBookinglist = bookingService.viewAllBooking(key);
		
		
		return new ResponseEntity<List<Booking>>(saveBookinglist,HttpStatus.CREATED);
		
	}
	

	@GetMapping("/Bookings/{Bookingid}/{key}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable("Bookingid") Integer bookingId,@PathVariable("key") String key) throws BookingException, LoginException  {
	
		
		Booking saveBooking = bookingService.viewBooking(bookingId,key);
		
		
		return new ResponseEntity<Booking>(saveBooking,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Packagees/{id}")
	public ResponseEntity<Package> viewPackagebyId(@PathVariable("id") Integer PackageId) throws PackageException {
	
		
		Package savePackage = packageService.searchPackage(PackageId);
		
		
		return new ResponseEntity<Package>(savePackage,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/Packagees")
	public ResponseEntity<List<Package>> viewAllPackages( ) throws PackageException {
	
		
		List<Package> savePackagelist = packageService.viewAllPackages();
		
		
		return new ResponseEntity<List<Package>>(savePackagelist,HttpStatus.CREATED);
		
	}
	

	@GetMapping("/Routes/{key}")
	public ResponseEntity<List<Route>> viewAllRoutes(@PathVariable("key") String key ) throws RouteException, LoginException {
	
		
		List<Route> saveRoutelist =routeService.viewAllRoutes(key);
		
		
		return new ResponseEntity<List<Route>>(saveRoutelist,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/Bookings/{bookingId}/{key}")
	public ResponseEntity<String> cancelBooking(@PathVariable("bookingId") Integer bookingId ,@PathVariable("key") String key ) throws LoginException, BookingException  {
	
		
		String str=bookingService.cancelBooking(bookingId, key);
		
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
	}

}
