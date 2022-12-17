package com.travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.exception.BusException;
import com.travel.exception.HotelException;
import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.exception.TravelException;
import com.travel.model.Admin;
import com.travel.model.Bus;
import com.travel.model.Hotel;
import com.travel.model.Package;
import com.travel.model.Route;
import com.travel.model.Travel;
import com.travel.service.AdminService;
import com.travel.service.BusService;
import com.travel.service.HotelService;
import com.travel.service.PackageService;
import com.travel.service.RouteService;
import com.travel.service.TravelService;

@RestController
@RequestMapping("/Admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private TravelService travelService;
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private PackageService packageService;
	
	
	@PostMapping("/Admins")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws AdminException{
	
		
		Admin saveAdmin=adminService.createAdmin(admin);
		
		
		return new ResponseEntity<Admin>(saveAdmin,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Hotels")
	public ResponseEntity<Hotel> createHotels(@Valid @RequestBody Hotel hotel) throws HotelException{
	
		
		Hotel saveHotel=hotelService.createHotel(hotel);
		
		
		return new ResponseEntity<Hotel>(saveHotel,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Travels")
	public ResponseEntity<Travel> createTravels(@Valid @RequestBody Travel travel) throws TravelException{
	
		
		Travel saveTravel=travelService.createTravel(travel);
		
		
		return new ResponseEntity<Travel>(saveTravel,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Buses/{tid}")
	public ResponseEntity<Bus> createBus(@Valid @RequestBody Bus bus,@PathVariable("tid") Integer travelid) throws BusException,TravelException {
	
		
		Bus savebus=busService.createBus(bus,travelid);
		
		
		return new ResponseEntity<Bus>(savebus,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/Routes")
	public ResponseEntity<Route> createBus(@Valid @RequestBody Route route) throws RouteException {
	
		
		Route saveRoute=routeService.createRoute(route);
		
		
		return new ResponseEntity<Route>(saveRoute,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Packagees")
	public ResponseEntity<Package> createPackage(@Valid @RequestBody Package packagee) throws PackageException, RouteException {
	
		
		Package savePackage = packageService.createPackage(packagee);
		
		
		return new ResponseEntity<Package>(savePackage,HttpStatus.CREATED);
		
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
	

	@GetMapping("/Routes/{id}")
	public ResponseEntity<Route> viewRoutebyId(@PathVariable("id") Integer routeId) throws  RouteException {
	
		
		Route saveRoute = routeService.searchRoute(routeId);
		
		
		return new ResponseEntity<Route>(saveRoute,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/Routes")
	public ResponseEntity<List<Route>> viewAllRoutes( ) throws RouteException {
	
		
		List<Route> saveRoutelist =routeService.viewAllRoutes();
		
		
		return new ResponseEntity<List<Route>>(saveRoutelist,HttpStatus.CREATED);
		
	}
	

	
	
}
