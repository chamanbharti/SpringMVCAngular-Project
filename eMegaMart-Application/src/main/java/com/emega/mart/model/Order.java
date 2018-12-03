package com.emega.mart.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROD_ORDER")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="DELIVERY_ADDRESS")
	private String deliveryAddress;
	
	@Column(name="CC_NAME")
	private String ccName;
	
	@Column(name="CC_NUMBER")
	private Long ccNumber;
	
	@Column(name="CC_EXPIRY_DATE")
	private Date expiryDate;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public Long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Long ccNumber) {
		this.ccNumber = ccNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
