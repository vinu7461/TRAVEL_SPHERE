package com.travel.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.repository.BusRepo;
import com.travel.repository.HotelRepo;
import com.travel.repository.PackageRepo;
import com.travel.repository.RouteRepo;
import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.model.Bus;
import com.travel.model.Hotel;
import com.travel.model.Package;
import com.travel.model.Route;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private PackageRepo packageRepo;
	
	@Autowired
	private HotelRepo hotelRepo;
	
	
	@Override
	public Package createPackage(Package packagee) throws PackageException, RouteException {
		
		
    Route existingRoute=routeRepo.findRoute(packagee.getSource(), packagee.getDestination(),packagee.getJourneyDate());
		
       if(existingRoute==null) throw new RouteException("For this Destination Route is not Available");
	
       
       List<Bus> buslist=existingRoute.getBus();
       
       Collections.sort(buslist,(s1,s2)->s1.getCapacity()>s2.getCapacity()?+1:-1);  
       
       if(buslist.get(0).getCapacity()<packagee.getAvailableSeats()) throw new PackageException("For this packagee bus seats are not available");
		
       Hotel availablehotel = hotelRepo.findByHotelAddress(packagee.getDestination());
       
       if(availablehotel==null)throw new PackageException("For this packagee  hotel is not available"); 
		
       packagee.setHotel(availablehotel);
       
       packagee.setBus(buslist.get(0));
       
       buslist.get(0).setCapacity( buslist.get(0).getCapacity()-packagee.getAvailableSeats());
       
       packagee.setRoute(existingRoute);
       
       
        
        packageRepo.save(packagee);
		
		
		return packagee;
	
		
		
		
	
	 
	}

}
