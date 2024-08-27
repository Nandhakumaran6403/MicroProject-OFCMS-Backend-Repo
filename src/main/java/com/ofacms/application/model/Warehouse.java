package com.ofacms.application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Warehouses")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouseId;

	@Column(nullable = false, length = 255)
	private String warehouseName;

	@Column(length = 255)
	private String location;

	@Column(length = 255)
	private String manager;

	@Column(length = 255)
	private String contactInfo;

	public Warehouse() {
		super();
	}

	public Warehouse(int warehouseId, String warehouseName, String location, String manager, String contactInfo) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.location = location;
		this.manager = manager;
		this.contactInfo = contactInfo;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

}
