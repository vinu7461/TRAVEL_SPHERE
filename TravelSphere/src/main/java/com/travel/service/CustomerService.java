package com.travel.service;

import java.util.List;

import com.travel.exception.CustomerException;
import com.travel.exception.LoginException;
import com.travel.model.Customer;


public interface CustomerService {

	public Customer createCustomer(Customer customer) throws CustomerException;
	
public Customer getCustomer(Integer cusId,String key)throws CustomerException, LoginException;
	
	public List<Customer> ViewAllCustomer(String key)throws CustomerException, LoginException;
	
	public Customer updatecustomer(Customer customer,String key)throws CustomerException, LoginException;
	
	public Customer DeleteCustomer(Integer customer_id,String key)throws CustomerException, LoginException;
	
}
