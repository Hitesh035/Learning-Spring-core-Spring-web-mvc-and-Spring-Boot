package com.hitesh.springbootcarwale.dto;

public class CarsSold {
	private String brandName;
	private long modelId;
	private long totalUnitsSold;
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
	
	public long getTotalUnitsSold() {
		return totalUnitsSold;
	}
	public void setTotalUnitsSold(long totalUnitsSold) {
		this.totalUnitsSold = totalUnitsSold;
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
