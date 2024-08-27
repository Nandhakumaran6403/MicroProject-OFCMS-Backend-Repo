package com.ofacms.application.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AdministrativeUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminUserId;

	private String userName;

	private String email;

	private String password;

	private String role;

	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	public AdministrativeUser() {
		super();
	}

	public AdministrativeUser(int adminUserId, String userName, String email, String password, String role,
			Date lastLoginDate) {
		super();
		this.adminUserId = adminUserId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.lastLoginDate = lastLoginDate;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
