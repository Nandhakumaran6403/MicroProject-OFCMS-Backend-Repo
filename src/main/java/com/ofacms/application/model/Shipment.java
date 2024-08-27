package com.ofacms.application.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Shipments")
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipmentId;

	@ManyToOne
	@JoinColumn(name = "order_item_id", nullable = false)
	private OrderItem orderItem;

	@Column(nullable = true)
	private Timestamp shipmentDate;

	@Column(length = 255)
	private String trackingNumber;

	@Column(length = 255)
	private String corrier;

	@Column(nullable = false)
	private String status;

	public Shipment() {
		super();
	}

	public Shipment(int shipmentId, OrderItem orderItem, Timestamp shipmentDate, String trackingNumber, String corrier,
			String status) {
		super();
		this.shipmentId = shipmentId;
		this.orderItem = orderItem;
		this.shipmentDate = shipmentDate;
		this.trackingNumber = trackingNumber;
		this.corrier = corrier;
		this.status = status;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Timestamp getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Timestamp shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCorrier() {
		return corrier;
	}

	public void setCorrier(String corrier) {
		this.corrier = corrier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
