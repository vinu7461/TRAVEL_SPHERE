package com.travel.repository;

import com.travel.model.Feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	public List<Feedback> findByUserId(Integer userId);

}
