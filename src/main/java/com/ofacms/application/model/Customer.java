package com.ofacms.application.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column(nullable = true, length = 100)
	private String firstName;

	@Column(nullable = true, length = 100)
	private String lastName;

	@Column(nullable = true, length = 255, unique = true)
	private String email;

	@Column(length = 20)
	private String phone;

	@Column(length = 255)
	private String address;

	@Column(length = 100)
	private String city;

	@Column(length = 100)
	private String state;

	@Column(length = 20)
	private String zipCode;

	@Column(length = 100)
	private String country;

	@Column(nullable = true, length = 50, unique = true)
	private String username;

	@Column(nullable = true, length = 255)
	private String passwordHash;

	@Column(nullable = true)
	private Timestamp createdAt;

	@Column(nullable = true)
	private Timestamp updatedAt;

	private String role = "user";

	public Customer() {
		super();
	}

	public Customer(int customerId, String firstName, String lastName, String email, String phone, String address,
			String city, String state, String zipCode, String country, String username, String passwordHash,
			Timestamp createdAt, Timestamp updatedAt, String role) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.username = username;
		this.passwordHash = passwordHash;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
