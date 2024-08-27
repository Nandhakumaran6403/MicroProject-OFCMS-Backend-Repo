package com.ofacms.application.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "warehouse_id", nullable = false)
	private Warehouse warehouse;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private Timestamp lastUpdated;

	public Inventory() {
		super();
	}

	public Inventory(int inventoryId, Product product, Warehouse warehouse, int quantity, Timestamp lastUpdated) {
		super();
		this.inventoryId = inventoryId;
		this.product = product;
		this.warehouse = warehouse;
		this.quantity = quantity;
		this.lastUpdated = lastUpdated;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
