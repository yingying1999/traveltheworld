package com.sikiedu.traveltheworld.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long custID;
	private Long resvKey;
	private String resvType;
	public Reservation() {
		
	}
	public Reservation(Long id, Long custID, Long resvKey, String resvType) {
		super();
		this.id = id;
		this.custID = custID;
		this.resvKey = resvKey;
		this.resvType = resvType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustID() {
		return custID;
	}
	public void setCustID(Long custID) {
		this.custID = custID;
	}
	public Long getResvKey() {
		return resvKey;
	}
	public void setResvKey(Long resvKey) {
		this.resvKey = resvKey;
	}
	public String getResvType() {
		return resvType;
	}
	public void setResvType(String resvType) {
		this.resvType = resvType;
	}
	
	
}
