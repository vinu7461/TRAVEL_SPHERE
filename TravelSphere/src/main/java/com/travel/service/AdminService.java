package com.travel.service;

import com.travel.exception.AdminException;
import com.travel.model.Admin;

public interface AdminService {

	public Admin createAdmin(Admin admin) throws AdminException;
	
}
