package com.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.repository.BusRepo;
import com.travel.repository.HotelRepo;
import com.travel.repository.PackageRepo;
import com.travel.repository.RouteRepo;
import com.travel.exception.PackageException;
import com.travel.model.Hotel;
import com.travel.model.Package;

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
	public Package createPackage(Package packagee) throws PackageException {
		return packagee;
	
		
		
		
	
	 
	}

}
