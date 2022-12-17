package com.travel.service;

import com.travel.model.Feedback;
import org.springframework.stereotype.Service;
import com.travel.exception.CustomerException;
import com.travel.exception.FeedbackException;



import java.util.List;
@Service
public interface FeedbackService {
    Feedback addFeedback(Feedback feedback, Integer id)throws CustomerException;
    Feedback findByFeedbackId(Integer id)throws FeedbackException;
    List<Feedback> findByCustomerId(Integer id)throws FeedbackException, CustomerException;
    List<Feedback> viewAllFeedback() throws FeedbackException;
}
