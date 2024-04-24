package com.cloudbees.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TICKETS")
public class TicketsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fromcity")
	private String fromCity;
	
	@Column(name="tocity")
	private String toCity;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="seatid")
	private int seatid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSeatid() {
		return seatid;
	}

	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}

	public TicketsEntity(int id, String fromCity, String toCity, Double price, int userid, int seatid) {
		super();
		this.id = id;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.price = price;
		this.userid = userid;
		this.seatid = seatid;
	}
	public TicketsEntity(String fromCity, String toCity, Double price, int userid, int seatid) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.price = price;
		this.userid = userid;
		this.seatid = seatid;
	}
	public TicketsEntity() {
		
	}
}
