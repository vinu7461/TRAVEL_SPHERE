package com.travel.service;

import com.travel.exception.BusException;
import com.travel.exception.TravelException;
import com.travel.model.Bus;

public interface BusService  {

	public Bus createBus(Bus bus,Integer travelid)throws BusException, TravelException; 
}
