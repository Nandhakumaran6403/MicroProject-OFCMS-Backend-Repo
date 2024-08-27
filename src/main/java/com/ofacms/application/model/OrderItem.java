package com.ofacms.application.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Order_Items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private BigDecimal price;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer orderItemId, Order order, Product product, Integer quantity, BigDecimal price) {
		super();
		this.orderItemId = orderItemId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
