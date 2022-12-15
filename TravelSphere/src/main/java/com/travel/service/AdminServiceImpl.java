package com.travel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.AdminException;
import com.travel.model.Admin;
import com.travel.model.UserType;
import com.travel.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Override

	public Admin createAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		
//		if(admin.getUserType().equals("ADMIN")) {  //we need to resolve enum issue
		
	   Admin existingAdmin=adminRepo.findByEmail(admin.getEmail());

	   if(existingAdmin!=null) throw new AdminException("Admin already Exists With this Email");
	   
	   
	  
	   Admin saveAdmin=adminRepo.save(admin);
	   
	 
	   return saveAdmin;}
//		else {
//			throw new AdminException("Admin already Exists With this userType");
//		}
//	}

	
	
}
