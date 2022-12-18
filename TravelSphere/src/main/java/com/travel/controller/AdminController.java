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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.exception.BusException;
import com.travel.exception.HotelException;
import com.travel.exception.LoginException;
import com.travel.exception.PackageException;
import com.travel.exception.ReportException;
import com.travel.exception.RouteException;
import com.travel.exception.TravelException;
import com.travel.model.Admin;
import com.travel.model.Bus;
import com.travel.model.Hotel;
import com.travel.model.Package;
import com.travel.model.Report;
import com.travel.model.Route;
import com.travel.model.Travel;
import com.travel.service.AdminService;
import com.travel.service.BusService;
import com.travel.service.HotelService;
import com.travel.service.PackageService;
import com.travel.service.ReportService;
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
	
	@PostMapping("/Hotels/{key}")
	public ResponseEntity<Hotel> createHotels(@Valid @RequestBody Hotel hotel,@PathVariable("key") String key) throws HotelException, LoginException{
	
		
		Hotel saveHotel=hotelService.createHotel(hotel,key);
		
		
		return new ResponseEntity<Hotel>(saveHotel,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Travels/{key}")
	public ResponseEntity<Travel> createTravels(@Valid @RequestBody Travel travel,@PathVariable("key") String key) throws TravelException, LoginException{
	
		
		Travel saveTravel=travelService.createTravel(travel,key);
		
		
		return new ResponseEntity<Travel>(saveTravel,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Travels/{key}")
	public ResponseEntity<List<Travel>> GetAllTravels(@PathVariable("key") String key) throws TravelException, LoginException{
	
		
		List<Travel> GetTravel=travelService.ViewTravel(key);
		
		
		return new ResponseEntity<List<Travel>>(GetTravel,HttpStatus.OK);
		
	}
	@GetMapping("/Travels/{id}/{key}")
	public ResponseEntity<Travel> getTravels(@Valid @PathVariable ("id") Integer travel_id,@PathVariable("key") String key) throws TravelException, LoginException{
	
		
		Travel GetTravel=travelService.getTravel(travel_id,key);
		
		
		return new ResponseEntity<Travel>(GetTravel,HttpStatus.OK);
		
	}
	
	@PutMapping("/Travels/{key}")
	public ResponseEntity<Travel> getTravels(@Valid @RequestBody Travel travel,@PathVariable("key") String key) throws TravelException, LoginException{
	
		Travel update_travel=travelService.updateTravel(travel,key);
		
		
		
		
		return new ResponseEntity<Travel>(update_travel,HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/Buses/{tid}/{key}")
	public ResponseEntity<Bus> createBus(@Valid @RequestBody Bus bus,@PathVariable("tid") Integer travelid,@PathVariable("key") String key) throws BusException,TravelException, LoginException {
	
		
		Bus savebus=busService.createBus(bus,travelid,key);
		
		
		return new ResponseEntity<Bus>(savebus,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/Routes/{key}")
	public ResponseEntity<Route> createRoute(@Valid @RequestBody Route route,@PathVariable("key") String key) throws RouteException, LoginException {
	
		
		Route saveRoute=routeService.createRoute(route,key);
		
		
		return new ResponseEntity<Route>(saveRoute,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Packagees/{key}")
	public ResponseEntity<Package> createPackage(@Valid @RequestBody Package packagee,@PathVariable("key") String key) throws PackageException, RouteException, LoginException {
	
		
		Package savePackage = packageService.createPackage(packagee,key);
		
		
		return new ResponseEntity<Package>(savePackage,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Packagees/{id}")
	public ResponseEntity<Package> viewPackagebyId(@PathVariable("id") Integer PackageId,@PathVariable("key") String key) throws PackageException {
	
		
		Package savePackage = packageService.searchPackage(PackageId);
		
		
		return new ResponseEntity<Package>(savePackage,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/Packagees")
	public ResponseEntity<List<Package>> viewAllPackages( ) throws PackageException {
	
		
		List<Package> savePackagelist = packageService.viewAllPackages();
		
		
		return new ResponseEntity<List<Package>>(savePackagelist,HttpStatus.CREATED);
		
	}
	

	@GetMapping("/Routes/{id}/{key}")
	public ResponseEntity<Route> viewRoutebyId(@PathVariable("id") Integer routeId,@PathVariable("key") String key) throws  RouteException, LoginException {
	
		
		Route saveRoute = routeService.searchRoute(routeId,key);
		
		
		return new ResponseEntity<Route>(saveRoute,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/Routes/{key}")
	public ResponseEntity<List<Route>> viewAllRoutes(@PathVariable("key") String key) throws RouteException, LoginException {
	
		
		List<Route> saveRoutelist =routeService.viewAllRoutes(key);
		
		
		return new ResponseEntity<List<Route>>(saveRoutelist,HttpStatus.CREATED);
		
	}
	


	

	
	
}
