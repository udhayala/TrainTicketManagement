package com.cloudbees.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.UsersEntity;
import com.cloudbees.repository.TicketRepository;
import com.cloudbees.repository.TrainSeats;
import com.cloudbees.repository.UserRepository;

@Service
public class TicketService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TrainSeats trainSeatsRepository;
	@Autowired
	TicketRepository ticketRepository;
	
	public HashMap<String,Object> bookTicket(
			String firstname,
			String lastname,
			String emailaddress,
			int trainid,
			String fromCity,
			String toCity
			) {
		//User
		java.util.Optional<UsersEntity> user = userRepository.getUserByEmailAddress(emailaddress);
		UsersEntity newUser = new UsersEntity();
		if(!user.isPresent())
			newUser = userRepository.save(new UsersEntity(firstname, lastname, emailaddress));
		
		int userid = user.isPresent()?user.get().getId():newUser.getId();
		
		//Seat availability
		int seatid = trainSeatsRepository.getAvailableSeat(trainid).get(0).getId();
		
		//Create new ticket
		TicketsEntity ticketEntity = ticketRepository.save(new TicketsEntity(fromCity,toCity,5.0,userid,seatid));
		return formatTicketReciept(ticketEntity, user.isPresent()?user.get():newUser);
		
	}
	
	public HashMap<String, Object> formatTicketReciept(TicketsEntity ticketEntity, UsersEntity userEntity) {
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("from", ticketEntity.getFromCity());
		result.put("to", ticketEntity.getToCity());
		result.put("price", ticketEntity.getPrice());
		result.put("firstname", userEntity.getFirstname());
		result.put("lastname", userEntity.getLastname());
		result.put("emailaddress", userEntity.getEmailaddress());
		return result;
	}
	
	public HashMap<String,Object> viewTicket(int ticketId) {
		Optional<TicketsEntity> ticketsEntity = ticketRepository.getTicketById(ticketId);
		if(ticketsEntity.isEmpty()) {
			return null;
		}
		Optional<UsersEntity> usersEntity = userRepository.getUserById(ticketsEntity.get().getUserid());
		if(usersEntity.isEmpty()) {
			return null;
		}else {
			return formatTicketReciept(ticketsEntity.get(), usersEntity.get());
		}
	}
	
	public void deleteTicket(int userId) {
		List<TicketsEntity> tickets = ticketRepository.getTicketsBookedForUser(userId);
		for(TicketsEntity ti:tickets) {
			ticketRepository.deleteById(ti.getId());
		}
		
	}
	
	public TicketsEntity modifySeat(String emailaddress, String seatnumber) {
		TicketsEntity ticketsEntity = ticketRepository.getTicketForUserAndSeat(emailaddress, seatnumber).get(0);
		//Seat availability
		int newSeatId = trainSeatsRepository.getAvailableSeat(100).get(0).getId();
		//update seat number
		ticketsEntity.setSeatid(newSeatId);
		TicketsEntity newTicketEntity  = ticketRepository.save(ticketsEntity);
		return newTicketEntity;
	}
	public List<Object[]> viewSeats(char section) {
		return trainSeatsRepository.viewSeatsInSection(section);
	}
}
