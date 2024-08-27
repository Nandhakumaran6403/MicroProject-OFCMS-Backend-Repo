package com.ofacms.application.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(nullable = false, length = 255)
	private String productName;

	@Lob
	private String description;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = true)
	private int stockQuantity;

	private String categoryName;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private Timestamp updatedAt;

	@Lob
	@Column(nullable = true, length = 100000000)
	private byte[] imageUrl;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String description, BigDecimal price, int stockQuantity,
			String categoryName, Timestamp createdAt, Timestamp updatedAt, byte[] imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.categoryName = categoryName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public byte[] getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}

}