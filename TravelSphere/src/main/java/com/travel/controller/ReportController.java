package com.travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.exception.LoginException;
import com.travel.exception.ReportException;
import com.travel.model.Report;
import com.travel.service.ReportService;
@RestController
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	
	@PostMapping("/Report/{key}")
	public ResponseEntity<Report> createReport(@Valid @RequestBody Report report,@PathVariable("key") String key) throws  ReportException, LoginException {
	
		
		Report saveReport = reportService.addReport(report,key);
		
		
		return new ResponseEntity<Report>(report,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Report/{id}/{key}")
	public ResponseEntity<Report> getReport(@Valid @PathVariable ("id") Integer report_id,@PathVariable("key") String key) throws ReportException, LoginException{
	
		
		Report GetReport=reportService.viewReport(report_id,key);
		
		
		return new ResponseEntity<Report>(GetReport,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/Report/{key}")
	public ResponseEntity<List<Report>> GetAllReports(@PathVariable("key") String key) throws ReportException, LoginException{
	
		
		List<Report> GetReports=reportService.ViewAllReport(key);
		
		
		return new ResponseEntity<List<Report>>(GetReports,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/Report/{id}/{key}")
	public ResponseEntity<Report> ReportDelete(@Valid @PathVariable ("id") Integer report_id,@PathVariable("key") String key) throws ReportException, LoginException{
	
		
		Report GetDeletedReport=reportService.DeleteReport(report_id,key);
		
		
		return new ResponseEntity<Report>(GetDeletedReport,HttpStatus.OK);
		
	}

}
