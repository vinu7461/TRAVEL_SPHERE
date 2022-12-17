package com.travel.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.LoginException;
import com.travel.model.Admin;
import com.travel.model.CurrentSession;
import com.travel.model.Customer;
import com.travel.model.LoginDto;
import com.travel.repository.AdminRepo;
import com.travel.repository.CustomerRepo;
import com.travel.repository.SessionRepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	SessionRepo sessionRepo;
	
	

	@Override
	public String logIntoAccount(LoginDto dto) throws LoginException {
	
		if(dto.getUserType().equals("CUSTOMER")){
			
			CurrentSession currentUserSession;
			
			Customer existingCustomer= customerRepo.findByEmail(dto.getEmail());
			if(existingCustomer==null)
				throw new LoginException("Please Enter a valid CREDENTIALS");
			
		java.util.Optional<CurrentSession>	validCustomerSessionOpt =  sessionRepo.findById(existingCustomer.getUserId());
		
			if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
	
		if(existingCustomer.getPassword().equals(dto.getPassword())) {;
			
			String key= RandomString.make(6);
			
			
			
			 currentUserSession = new CurrentSession(existingCustomer.getUserId(),key,LocalDateTime.now(),dto.getUserType());
			
			sessionRepo.save(currentUserSession);
		

			return key;
		}else
			throw new LoginException("Passowrd incorrect");
		}
		

		
		if(dto.getUserType().equals("ADMIN")){
			
			CurrentSession currentUserSession2;
			
			Admin existingAdmin= adminRepo.findByEmail(dto.getEmail());
			if(existingAdmin==null)
				throw new LoginException("Please Enter a valid CREDENTIALS");
			
		java.util.Optional<CurrentSession>	validCustomerSessionOpt =  sessionRepo.findById(existingAdmin.getUserId());
		
			if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
		
		if(existingAdmin.getPassword().equals(dto.getPassword())){;
			
			String key= RandomString.make(6);
			
			
			
			 currentUserSession2 = new CurrentSession(existingAdmin.getUserId(),key,LocalDateTime.now(),dto.getUserType());
			
			sessionRepo.save(currentUserSession2);
		

			return key;
		}else
			throw new LoginException("Password Incorrect");
		}
		
		
		else
			throw new LoginException("Please Enter a valid User Type ADMIN/CUSTOMER");
		
			
		
		
		
		
		
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		
		CurrentSession validUserSession = sessionRepo.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("NOT A VALID KEY");
			
		}
		
		sessionRepo.delete(validUserSession);
		return "User Loged Out SusessFully";
	}





	
	
}
