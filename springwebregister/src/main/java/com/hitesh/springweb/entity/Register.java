package com.hitesh.springweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springweb.constants.AppConstants;

@Entity
@Table (name = AppConstants.REGISTER_TABLE_NAME)
public class Register {
	
	@Id
	@GenericGenerator(name = "idGEn", strategy = "increment" )
	@GeneratedValue(generator = "idGen")
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "cno")
	private String cno;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "pincode")
	private String pincode;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", email=" + email + ", cno=" + cno + ", city=" + city + ", country="
				+ country + ", pincode=" + pincode + "]";
	}
	
}
