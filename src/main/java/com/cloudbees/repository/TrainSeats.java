package com.cloudbees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.TrainSeatsEntity;

@Repository
public interface TrainSeats extends JpaRepository<TrainSeatsEntity, Integer>{
	@Query("select ts from TrainEntity tr INNER JOIN TrainSeatsEntity ts ON tr.id=ts.trainid LEFT JOIN TicketsEntity t ON ts.id=t.seatid where t.seatid is null and tr.id=?1 order by ts.seatnumber")
	List<TrainSeatsEntity> getAvailableSeat(int trainId);

	@Query("select ts.seatnumber, u.firstname,u.lastname,u.emailaddress from TrainSeatsEntity ts LEFT OUTER JOIN TicketsEntity t ON ts.id=t.seatid LEFT OUTER JOIN UsersEntity u on u.id=t.userid where ts.trainid=100 and ts.section=?1")
	List<Object[]> viewSeatsInSection(char section);
}
