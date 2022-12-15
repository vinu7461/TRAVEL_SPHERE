package com.travel.service;

import com.travel.exception.AdminException;
import com.travel.exception.CustomerException;
import com.travel.model.Admin;
import com.travel.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws CustomerException;
	
}
