package com.emega.mart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROD_ORDER_DETAILS")
public class OrdetDetail {
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_DTL_ID")
	private Long orderDetailId;
	
	@Column(name="ORDER_QTY")
	private Long orderQuantity;
	
	@Column(name="ORDER_PRICE")
	private Double orderPrice;
	
	@ManyToOne(targetEntity=Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")
	private Set<Order> order;
	
	@ManyToOne(targetEntity=Product.class,cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Set<Product> product;

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
