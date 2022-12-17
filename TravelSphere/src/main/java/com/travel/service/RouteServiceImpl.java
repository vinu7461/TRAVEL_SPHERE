package com.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.LoginException;
import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.model.CurrentSession;
import com.travel.model.Package;
import com.travel.model.Route;
import com.travel.repository.BusRepo;
import com.travel.repository.RouteRepo;
import com.travel.repository.SessionRepo;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private SessionRepo sessionRepo; 
	
	@Override
	public Route createRoute(Route route,String key) throws RouteException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
	   
	Route exsitingRoute = routeRepo.findRoute(route.getRouteFrom(),route.getRouteTo(),route.getDateOfJourney());
	
	if(exsitingRoute!=null) throw new RouteException("Route already edxistt for this date");
	
	
    
	route.getBus().addAll(busRepo.findByJourneyDateAndBusFromAndBusTo(route.getDateOfJourney(),route.getRouteFrom(), route.getRouteTo()));
	
	 if(route.getBus().size()==0) throw new RouteException(" route not created because buses are not available");
	
	return routeRepo.save(route);
	

	}

	@Override
	public Route searchRoute(Integer routeId,String key) throws RouteException, LoginException {
		
		
		// TODO Auto-generated method stub
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
		return routeRepo.findById(routeId).orElseThrow(()-> new RouteException("Route not found"));
		
		
	}

	@Override
	public List<Route> viewAllRoutes(String key) throws RouteException, LoginException {
		// TODO Auto-generated method stub
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
        List<Route>routes=routeRepo.findAll();
		
		if(routes.size()==0) throw new RouteException("Route not found");
		
		return routes;
	}

}
