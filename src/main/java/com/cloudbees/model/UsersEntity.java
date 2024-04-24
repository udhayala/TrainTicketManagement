package com.cloudbees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="emailaddress")
	private String emailaddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public UsersEntity(String firstname, String lastname, String emailaddress) {
		super();
//		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
	}
	public UsersEntity(int id, String firstname, String lastname, String emailaddress) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
	}
	public UsersEntity() {
		
	}
}
