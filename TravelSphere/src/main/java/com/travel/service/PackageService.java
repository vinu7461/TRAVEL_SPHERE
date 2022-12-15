package com.travel.service;

import com.travel.exception.PackageException;
import com.travel.model.Package;

public interface PackageService {
	
	public Package createPackage(Package pack) throws PackageException ;

}
