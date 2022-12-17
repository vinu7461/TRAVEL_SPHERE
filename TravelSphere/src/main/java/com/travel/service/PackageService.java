package com.travel.service;

import java.util.List;

import com.travel.exception.PackageException;
import com.travel.exception.RouteException;
import com.travel.model.Package;

public interface PackageService {
	
	public Package createPackage(Package pack) throws PackageException, RouteException ;
	
	public Package searchPackage(Integer packageId) throws PackageException;
	
	public List<Package> viewAllPackages() throws PackageException;

}
