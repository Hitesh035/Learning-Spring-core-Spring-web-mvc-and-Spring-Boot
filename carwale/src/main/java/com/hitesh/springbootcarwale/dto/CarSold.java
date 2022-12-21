package com.hitesh.springbootcarwale.dto;

import java.io.Serializable;

public class CarSold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 998L;
	private String brandName;
	private long modelId;
	
	private double totalAmountReceived;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	
	
	public double getTotalAmountReceived() {
		return totalAmountReceived;
	}
	public void setTotalAmountReceived(double totalAmountReceived) {
		this.totalAmountReceived = totalAmountReceived;
	}
	@Override
	public String toString() {
		return "CarSold [brandName=" + brandName + ", modelId=" + modelId + ", amountReceived=" + totalAmountReceived + "]";
	}
	
	
}
