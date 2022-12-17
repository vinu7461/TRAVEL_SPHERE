package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.LoginException;
import com.travel.model.LoginDto;
import com.travel.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> USerLogin(@RequestBody LoginDto logindto) throws LoginException{
		
	String result=	loginService.logIntoAccount(logindto);
		
	
	return new ResponseEntity<String>(result,HttpStatus.OK);

}
	@DeleteMapping("/logout")
	public ResponseEntity<String> UserLogout(@RequestParam(required = false)String key) throws LoginException{
		String Result=loginService.logOutFromAccount(key);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
