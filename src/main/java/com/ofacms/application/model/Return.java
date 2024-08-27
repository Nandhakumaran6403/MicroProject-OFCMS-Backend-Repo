package com.ofacms.application.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Returns")
public class Return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnId;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@Column(nullable = true)
	private Timestamp returnDate;

	@Lob
	private String reason;

	@Column(nullable = false)
	private String status;

	public Return() {
		super();
	}

	public Return(int returnId, Order order, Timestamp returnDate, String reason, String status) {
		super();
		this.returnId = returnId;
		this.order = order;
		this.returnDate = returnDate;
		this.reason = reason;
		this.status = status;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
