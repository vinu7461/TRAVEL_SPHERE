package com.travel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.BusException;
import com.travel.exception.LoginException;
import com.travel.exception.TravelException;
import com.travel.model.Bus;
import com.travel.model.CurrentSession;
import com.travel.model.Travel;
import com.travel.repository.BusRepo;
import com.travel.repository.SessionRepo;
import com.travel.repository.TravelRepo;

@Service
public class BusServiceImpl implements BusService{
    
	@Autowired
    private BusRepo busrepo;
	
	@Autowired
    private TravelRepo travelrepo;
	
	@Autowired
	private SessionRepo sessionRepo; 
	
	@Override
	public Bus createBus(Bus bus,Integer travelid,String key) throws BusException, TravelException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
		Optional<Travel> opt = travelrepo.findById(travelid);
		
		if(opt.isPresent()) {
			
		 Travel travel = opt.get();
		 
		 bus.setTravel(travel);
		 bus.setTravelName(travel.getTravelName());
		 travel.getBusList().add(bus);
		Bus newBus = busrepo.save(bus);
		 return newBus;
			
		}else {
			throw new TravelException("travel company  not exist with id "+travelid);
		}

	}

}
