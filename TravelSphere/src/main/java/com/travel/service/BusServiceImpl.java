package com.travel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.BusException;
import com.travel.exception.TravelException;
import com.travel.model.Bus;
import com.travel.model.Travel;
import com.travel.repository.BusRepo;
import com.travel.repository.TravelRepo;

@Service
public class BusServiceImpl implements BusService{
    
	@Autowired
    private BusRepo busrepo;
	
	@Autowired
    private TravelRepo travelrepo;
	
	
	@Override
	public Bus createBus(Bus bus,Integer travelid) throws BusException, TravelException {
		
		Optional<Travel> opt = travelrepo.findById(travelid);
		
		if(opt.isPresent()) {
			
		 Travel travel = opt.get();
		 
		 bus.setTravel(travel);
		 bus.setTravelName(travel.getTravelName());
		 travel.getBusList().add(bus);
		 busrepo.save(bus);
		 return bus;
			
		}else {
			throw new TravelException("travel company  not exist with id "+travelid);
		}

	}

}
