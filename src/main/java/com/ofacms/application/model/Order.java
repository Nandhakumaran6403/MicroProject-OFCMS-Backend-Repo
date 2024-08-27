package com.ofacms.application.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "order_date")
	private LocalDateTime orderDate;

	private String status;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	private String paymentMethod;

	private String paymentStatus;

	public Order() {
		super();
	}

	public Order(int orderId, Customer customer, LocalDateTime orderDate, String status, BigDecimal totalAmount,
			String paymentMethod, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.status = status;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
