package com.cloudbees.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;

import com.cloudbees.controller.TicketController;
import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.UsersEntity;
import com.cloudbees.repository.TicketRepository;
import com.cloudbees.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestTrainTicketManagement {
	private MockMvc mockMvc;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private TicketController ticketController;
	
	UsersEntity user1 = new UsersEntity(1,"tom","boi","tom.boi@gmail.com");
	UsersEntity user2 = new UsersEntity(2,"Wendy","Rey","w.rey@gmail.com");
	UsersEntity user3 = new UsersEntity(3,"harvard","shum","harvard@gmail.com");
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
	}
	
	@Test
	public void getUser() throws Exception {
		
		
		
	}
}
