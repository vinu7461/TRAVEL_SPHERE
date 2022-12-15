package com.travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.exception.CustomerException;
import com.travel.model.Admin;
import com.travel.model.Customer;
import com.travel.service.AdminService;
import com.travel.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/Customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
	
		
		Customer saveCustomer=customerService.createCustomer(customer);
		
		
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.CREATED);
		
	}

}
