package com.hitesh.springbootcarwale.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private long id;
	
	
	private String paymentMode;
	
	
	private long modelId;
	
	
	private long orderId;
	
	
	private double amountPaid;
	
	
	private double advancePaid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", paymentMode=" + paymentMode + ", brandId=" + modelId + ", orderId=" + orderId
				+ ", amountPaid=" + amountPaid + ", advancePaid=" + advancePaid + "]";
	}
	
	

}
