package com.ofacms.application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Return_Items")
public class ReturnItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnItemId;

	@ManyToOne
	@JoinColumn(name = "return_id", nullable = false)
	private Return returnItem;

	@ManyToOne
	@JoinColumn(name = "order_item_id", nullable = false)
	private OrderItem orderItem;

	@Column(nullable = false)
	private int quantity;

	public ReturnItem() {
		super();
	}

	public ReturnItem(int returnItemId, Return returnItem, OrderItem orderItem, int quantity) {
		super();
		this.returnItemId = returnItemId;
		this.returnItem = returnItem;
		this.orderItem = orderItem;
		this.quantity = quantity;
	}

	public int getReturnItemId() {
		return returnItemId;
	}

	public void setReturnItemId(int returnItemId) {
		this.returnItemId = returnItemId;
	}

	public Return getReturnItem() {
		return returnItem;
	}

	public void setReturnItem(Return returnItem) {
		this.returnItem = returnItem;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
