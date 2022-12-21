package com.hitesh.springbootcarwale.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springbootcarwale.appconstants.AppConstants;

@javax.persistence.Entity
@javax.persistence.Table(name = AppConstants.BRAND_TABLE_NAME)
public class Brand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@javax.persistence.Id
	@javax.persistence.Column(name = "id")
	@GenericGenerator(name = "idGen", strategy = "increment")
	@javax.persistence.GeneratedValue(generator = "idGen")
	private long id;
	
	@javax.persistence.Column(name = "name")
	private String name;
	
	@javax.persistence.Column(name = "estd_year")
	private String estdYear;
	
	@javax.persistence.Column(name = "head_quaters")
	private String headQuaters;
	
	@javax.persistence.Column(name = "ceo_name")
	private String ceoName;
	
	@javax.persistence.Column(name = "brand_value")
	private double brandValue;

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

	public String getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(String estdYear) {
		this.estdYear = estdYear;
	}

	public String getHeadQuaters() {
		return headQuaters;
	}

	public void setHeadQuaters(String headQuaters) {
		this.headQuaters = headQuaters;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public double getBrandValue() {
		return brandValue;
	}

	public void setBrandValue(double brandValue) {
		this.brandValue = brandValue;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", estdYear=" + estdYear + ", headQuaters=" + headQuaters
				+ ", ceoName=" + ceoName + ", brandValue=" + brandValue + "]";
	}
	
	
}
