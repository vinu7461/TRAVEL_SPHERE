package com.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.exception.LoginException;
import com.travel.exception.ReportException;
import com.travel.model.CurrentSession;
import com.travel.model.Report;
import com.travel.repository.ReportRepo;
import com.travel.repository.SessionRepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportRepo reportRepo;
	
	@Autowired
	private SessionRepo sessionRepo; 
	
	// REPORT MAPPING TO BE DONE
	
	@Override
	public Report addReport(Report report,String key) throws ReportException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
	 Report newreport=reportRepo.save(report);
		
		return newreport;
	}

	@Override
	public Report viewReport(Integer ReportId,String key) throws ReportException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
		java.util.Optional<Report> opt=reportRepo.findById(ReportId);
		
		if(opt.isPresent()) {
			Report report=opt.get();
			return report;
		}else
			throw new ReportException("No Report Found");
		
	}

	@Override
	public List<Report> ViewAllReport(String key) throws ReportException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
		List<Report> reports=reportRepo.findAll();
		if(reports.size()==0)
			throw new ReportException("No Report Registered");
		else
		return reports;
	}

	@Override
	public Report DeleteReport(Integer ReportId,String key) throws ReportException, LoginException {
		
		 CurrentSession currentSession=	sessionRepo.findByUuid(key);
		    if(currentSession==null) throw new LoginException("Please enter valid key ");
		  
		  	if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized"); 
		    			
		
		
		java.util.Optional<Report> opt=reportRepo.findById(ReportId);
		
		if(opt.isPresent()) {
			Report existingReport=opt.get();
			reportRepo.delete(existingReport);
			return existingReport;
		}else
			throw new ReportException("No Report Record Find With this Id");
		
	
	}

}
