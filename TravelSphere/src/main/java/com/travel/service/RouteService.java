package com.travel.service;

import java.util.List;


import com.travel.exception.RouteException;

import com.travel.model.Route;

public interface RouteService {

	
	public Route createRoute(Route route)throws RouteException;
	
public Route searchRoute(Integer routeId) throws RouteException;
	
	public List<Route> viewAllRoutes() throws RouteException;

}
