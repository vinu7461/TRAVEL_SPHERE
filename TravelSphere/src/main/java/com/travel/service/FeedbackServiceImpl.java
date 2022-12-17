package com.travel.service;

import com.travel.exception.CustomerException;
import com.travel.exception.FeedbackException;
import com.travel.model.Customer;
import com.travel.model.Feedback;
import com.travel.repository.CustomerRepo;
import com.travel.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Feedback addFeedback(Feedback feedback, Integer id) throws CustomerException {

        Optional<Customer> customer=customerRepo.findById(id);
        if (customer.isPresent()){
            Customer recentCustomer=customer.get();
            List<Feedback> feedbackList = recentCustomer.getFeedback();
            feedbackList.add(feedback);
            customerRepo.save(recentCustomer);
            return feedback;


        }else {
            throw new  CustomerException("Customer Not Found");
        }
    }

    @Override
    public Feedback findByFeedbackId(Integer id) throws FeedbackException {
        Optional<Feedback> recentCustomer =feedbackRepo.findById(id);
        if (recentCustomer.isPresent()){
            return recentCustomer.get();
        }
        else {
            throw new FeedbackException("No feedback has been provided by this customer.");
        }
    }

    @Override
    public List<Feedback> findByCustomerId(Integer id) throws FeedbackException, CustomerException {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()) {
            Customer previousCustomer = customer.get();
            List<Feedback> feedbackList = previousCustomer.getFeedback();
            if(feedbackList.size()>0) {
                return feedbackList;
            }else {
                throw new FeedbackException("We do not have any feedback from the customer");
            }
        }else {
            throw new CustomerException("The customer could not be found.");
        }
    }

    @Override
    public List<Feedback> viewAllFeedback() throws FeedbackException {
        List<Feedback> feedbackList = feedbackRepo.findAll();
        if(feedbackList.size()>0) {
            return feedbackList;
        }else {
            throw new FeedbackException("We have not received any feedback yet.");
        }
    }


}
