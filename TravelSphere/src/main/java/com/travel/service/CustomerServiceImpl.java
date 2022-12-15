package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.travel.exception.AdminException;
import com.travel.exception.CustomerException;
import com.travel.model.Admin;
import com.travel.model.Customer;
import com.travel.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
		System.out.println(customer.getUserType());
		
		//we need to resolve enum issue
			   Customer existingCustomer=customerRepo.findByEmail(customer.getEmail());

			   if(existingCustomer!=null) throw new CustomerException("Customer already Exists With this Email");
			   
			   
			  
			   Customer saveCustomer=customerRepo.save(customer);
			   
			 
			   return saveCustomer;
				
		
		
		
	}
	

}
