package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>{

}
