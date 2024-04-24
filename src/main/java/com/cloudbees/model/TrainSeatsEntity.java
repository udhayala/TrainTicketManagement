package com.cloudbees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TRAIN_SEATS")
public class TrainSeatsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="trainid")
	private int trainid;
	
	@Column(name="seatnumber")
	private String seatnumber;
	
	@Column(name="section")
	private char section;

	public TrainSeatsEntity(int id, int trainid, String seatnumber, char section) {
		super();
		this.id = id;
		this.trainid = trainid;
		this.seatnumber = seatnumber;
		this.section = section;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getTrainid() {
		return trainid;
	}



	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}



	public String getSeatnumber() {
		return seatnumber;
	}



	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}



	public char getSection() {
		return section;
	}



	public void setSection(char section) {
		this.section = section;
	}



	public TrainSeatsEntity() {
		
	}
	
}
