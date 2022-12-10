package com.hitesh.springwebv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springwebv2.constants.AppConstants;

@Entity
@Table(name = AppConstants.THEATER_DETAILS)
public class TheaterInfo {
	
	@Id
	@Column(name = "theater_id")
	@GenericGenerator(name = "theaterIdGenerator", strategy = "increment")
	@GeneratedValue(generator = "theaterIdGenerator")
	private long theaterId;
	
	@Column(name = "theater_name")
	private String theaterName;
	
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "address")
	private String address;
	public long getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String name) {
		this.theaterName = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
