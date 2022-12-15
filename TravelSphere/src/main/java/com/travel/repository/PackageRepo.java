package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, Integer> {
	
	

}
