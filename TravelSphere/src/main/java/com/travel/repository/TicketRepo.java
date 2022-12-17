package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.model.Ticket;
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
  
	
	public Ticket findByBookingId(Integer bookingId);
	
}
