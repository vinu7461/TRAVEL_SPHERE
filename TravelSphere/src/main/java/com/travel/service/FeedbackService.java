package com.travel.service;

import com.travel.model.Feedback;
import org.springframework.stereotype.Service;
import com.travel.exception.CustomerException;
import com.travel.exception.FeedbackException;
import com.travel.exception.LoginException;

import java.util.List;

public interface FeedbackService {
	public Feedback addFeedback(Feedback feedback, String key) throws CustomerException, LoginException;

	public List<Feedback> findByCustomer(String key)throws FeedbackException, CustomerException, LoginException;
	public List<Feedback> viewAllFeedback(String key) throws FeedbackException, LoginException;
}