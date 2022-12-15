package com.travel.service;

import com.travel.exception.RouteException;
import com.travel.model.Route;

public interface RouteService {

	
	public Route createRoute(Route route)throws RouteException;
}
