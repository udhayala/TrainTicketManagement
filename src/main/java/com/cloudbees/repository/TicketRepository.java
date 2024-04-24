package com.cloudbees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.TrainEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketsEntity, Integer>{

	@Query("SELECT te from TicketsEntity te where te.id=?1")
	Optional<TicketsEntity> getTicketById(int ticketId);
	
	@Query("SELECT ti from TicketsEntity ti JOIN UsersEntity us ON ti.userid=us.id")
	List<TicketsEntity> getTicketsBookedForUser(int userid);
	
	@Query("select t from UsersEntity u JOIN TicketsEntity t on u.id=t.userid JOIN TrainSeatsEntity ts ON ts.id=t.seatid WHERE u.emailaddress=?1 and ts.seatnumber=?2")
	List<TicketsEntity> getTicketForUserAndSeat(String emailaddress, String seatnumber);
	
}
