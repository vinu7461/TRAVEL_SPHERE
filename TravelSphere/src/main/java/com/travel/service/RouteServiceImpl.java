package com.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.model.Package;
import com.travel.model.Route;
import com.travel.repository.BusRepo;
import com.travel.repository.RouteRepo;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Override
	public Route createRoute(Route route) throws RouteException {
	   
	Route exsitingRoute = routeRepo.findRoute(route.getRouteFrom(),route.getRouteTo(),route.getDateOfJourney());
	
	if(exsitingRoute!=null) throw new RouteException("Route already edxistt for this date");
    
	route.getBus().addAll(busRepo.findByJourneyDateAndBusFromAndBusTo(route.getDateOfJourney(),route.getRouteFrom(), route.getRouteTo()));
	
	
	return routeRepo.save(route);
	

	}

	@Override
	public Route searchRoute(Integer routeId) throws RouteException {
		// TODO Auto-generated method stub
		
		return routeRepo.findById(routeId).orElseThrow(()-> new RouteException("Route not found"));
		
		
	}

	@Override
	public List<Route> viewAllRoutes() throws RouteException {
		// TODO Auto-generated method stub
		
		
        List<Route>routes=routeRepo.findAll();
		
		if(routes.size()==0) throw new RouteException("Route not found");
		
		return routes;
	}

}
