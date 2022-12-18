package com.travel.service;

import java.util.List;

import com.travel.exception.LoginException;
import com.travel.exception.ReportException;
import com.travel.model.Report;

public interface ReportService {

	
	public Report addReport(Report report,String key)throws ReportException, LoginException;
	
	public Report viewReport(Integer ReportId,String key)throws ReportException, LoginException;
	
	public List<Report> ViewAllReport(String key) throws ReportException, LoginException;
	
	public Report DeleteReport(Integer ReportId,String key)throws ReportException, LoginException;
}
