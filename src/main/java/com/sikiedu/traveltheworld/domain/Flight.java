package com.sikiedu.traveltheworld.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long companyID;
	private String flightNum;
	private String price;
	private String numSeats;
	private String numAvail;
	private String fromCity;
	private String arivCity;
	public Flight(Long id, Long companyID, String flightNum, String price, String numSeats,
			String numAvail, String fromCity, String arivCity) {
		super();
		this.id = id;
		this.companyID = companyID;
		this.flightNum = flightNum;
		this.price = price;
		this.numSeats = numSeats;
		this.numAvail = numAvail;
		this.fromCity = fromCity;
		this.arivCity = arivCity;
	}
	public Flight() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(String numSeats) {
		this.numSeats = numSeats;
	}
	public String getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(String numAvail) {
		this.numAvail = numAvail;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getArivCity() {
		return arivCity;
	}
	public void setArivCity(String arivCity) {
		this.arivCity = arivCity;
	}



}
