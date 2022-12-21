package com.hitesh.springbootcarwale.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springbootcarwale.appconstants.AppConstants;

@javax.persistence.Entity
@javax.persistence.Table(name = AppConstants.MODEL_TABLE_NAME)
public class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@javax.persistence.Id
	@javax.persistence.Column(name = "id")
	@GenericGenerator(name = "idGen", strategy = "increment")
	@javax.persistence.GeneratedValue(generator = "idGen")
	private long id;
	
	@javax.persistence.Column(name = "name")
	private String name;
	
	@javax.persistence.Column(name = "brand_id")
	private long brandId;
	
	@javax.persistence.Column(name = "price")
	private double price;
	
	@javax.persistence.Column(name = "type")
	private String type;
	
	@javax.persistence.Column(name = "color")
	private String color;
	
	@javax.persistence.Column(name = "version")
	private String version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
