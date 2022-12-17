package com.travel.service;

import java.util.List;

import com.travel.exception.LoginException;
import com.travel.exception.RouteException;

import com.travel.model.Route;

public interface RouteService {

	
	public Route createRoute(Route route,String key)throws RouteException, LoginException;
	
public Route searchRoute(Integer routeId,String key) throws RouteException, LoginException;
	
	public List<Route> viewAllRoutes(String key) throws RouteException, LoginException;

}
