package com.travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.AdminException;
import com.travel.model.Admin;
import com.travel.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/Admins")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws AdminException{
	
		
		Admin saveAdmin=adminService.createAdmin(admin);
		
		
		return new ResponseEntity<Admin>(saveAdmin,HttpStatus.CREATED);
		
	}
	
}
