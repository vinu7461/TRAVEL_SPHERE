package com.travel.service;

import com.travel.exception.LoginException;
import com.travel.model.LoginDto;

public interface LoginService {
	
	public String logIntoAccount(LoginDto dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
