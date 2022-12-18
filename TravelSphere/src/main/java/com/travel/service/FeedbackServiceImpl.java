package com.travel.service;

import com.travel.exception.CustomerException;
import com.travel.exception.FeedbackException;
import com.travel.exception.LoginException;
import com.travel.model.CurrentSession;
import com.travel.model.Customer;
import com.travel.model.Feedback;
import com.travel.repository.CustomerRepo;
import com.travel.repository.FeedbackRepo;
import com.travel.repository.SessionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	
    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
	private SessionRepo sessionRepo;

    @Override
    public Feedback addFeedback(Feedback feedback, String key) throws CustomerException, LoginException {
    	
        CurrentSession currentSession=	sessionRepo.findByUuid(key);
	    if(currentSession==null) throw new LoginException("Please enter valid key ");
	  
	  	if(!currentSession.getUserType().equals("CUSTOMER")) throw new LoginException("You are not authorized");
	  	

	     Integer userId=currentSession.getUserId();
	     
	     if(userId!=feedback.getUserId()) throw new CustomerException("please enter correct userId");
	     
                 return  feedbackRepo.save(feedback);
      
    }

   
    @Override
    public List<Feedback> findByCustomer(String key) throws FeedbackException, CustomerException, LoginException {
    	
    	  CurrentSession currentSession=	sessionRepo.findByUuid(key);
  	    if(currentSession==null) throw new LoginException("Please enter valid key ");
  	  
  	  	if(!currentSession.getUserType().equals("CUSTOMER")) throw new LoginException("You are not authorized");
  	  	
  	           Integer userId=currentSession.getUserId();
    	
  	         List<Feedback> feedbacks= feedbackRepo.findByUserId(userId);
  	         
  	         if(feedbacks.size()==0) throw new FeedbackException("no feedback found");
  	         
  	         return feedbacks;
       
    }

    public List<Feedback> viewAllFeedback(String key) throws FeedbackException, LoginException {
    	
    	
  	  CurrentSession currentSession=	sessionRepo.findByUuid(key);
	    if(currentSession==null) throw new LoginException("Please enter valid key ");
	  
	  
    	
    	
        List<Feedback> feedbacks = feedbackRepo.findAll();
        
        if(feedbacks.size()==0) throw new FeedbackException("no feedback found");
	         
	         return feedbacks;


}

}

	
