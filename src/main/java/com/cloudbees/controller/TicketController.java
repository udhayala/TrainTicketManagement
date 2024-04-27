package com.cloudbees.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.service.TicketService;
import com.cloudbees.service.exception.TicketNotFoundException;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	//Adding test comment7
	@ExceptionHandler(TicketNotFoundException.class)
	@GetMapping("/viewTicket/{id}")
	public HashMap<String, Object> viewTicket(@PathVariable int id){
		return ticketService.viewTicket(id);
	}
	
	@PostMapping("/bookTicket")
	@ResponseBody
	public HashMap<String, Object> bookTicket(
			@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam String emailaddress,
			@RequestParam String fromCity,
			@RequestParam String toCity
			) {
		return ticketService.bookTicket(
				firstname, 
				lastname, 
				emailaddress, 
				100,
				fromCity,
				toCity
				);
	}
	
	 @DeleteMapping("/cancelTicket/{id}")
	 public void deleteTicket(@PathVariable int id) {
		 ticketService.deleteTicket(id);
	 }
	 
	@PutMapping("/modifySeat")
	@ResponseBody
	public TicketsEntity modifySeat(
			@RequestParam String emailaddress,
			@RequestParam String seatnumber
			) {
		return ticketService.modifySeat(emailaddress, seatnumber);
	}
	
	@GetMapping("/viewSection/{section}")
	public List<Object[]> viewSection(@PathVariable char section) {
		return ticketService.viewSeats(section);
	}
}
