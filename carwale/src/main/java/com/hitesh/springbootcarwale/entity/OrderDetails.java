package com.hitesh.springbootcarwale.entity;

import java.io.Serializable;

import com.hitesh.springbootcarwale.appconstants.AppConstants;

@javax.persistence.Entity
@javax.persistence.Table(name = AppConstants.ORDER_DETAILS_TABLE_NAME)
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@javax.persistence.Id
	@javax.persistence.Column(name = "id")
	
	private long id;
	
	@javax.persistence.Column(name = "payment_mode")
	private String paymentMode;
	
	@javax.persistence.Column(name = "brand_id")
	private long brandId;
	
	@javax.persistence.Column(name = "ordered_date")
	private String orderedDate;
	
	@javax.persistence.Column(name = "delivered_date")
	private String deliveredDate;
	
	@javax.persistence.Column(name = "delivery_status")
	private String deliveryStatus;
	
	@javax.persistence.Column(name = "advance_paid")
	private double advancePaid;
	
	@javax.persistence.Column(name = "total_amount_received")
	private double totalAmountReceived;

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

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public double getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}

	public double getTotalAmountReceived() {
		return totalAmountReceived;
	}

	public void setTotalAmountReceived(double totalAmountReceived) {
		this.totalAmountReceived = totalAmountReceived;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", paymentMode=" + paymentMode + ", brandId=" + brandId + ", orderedDate="
				+ orderedDate + ", deliveredDate=" + deliveredDate + ", deliveryStatus=" + deliveryStatus
				+ ", advancePaid=" + advancePaid + ", totalAmountReceived=" + totalAmountReceived + "]";
	}
	
	
}
