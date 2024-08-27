package com.ofacms.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.model.Customer;
import com.ofacms.application.model.Login;
import com.ofacms.application.service.AdministrativeUserService;
import com.ofacms.application.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdministrativeUserService administrativeUserService;

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Object login(@RequestBody Login login) {

		String email = login.getEmail();
		String password = login.getPassword();

		List<AdministrativeUser> admins = administrativeUserService.getAllAdministrativeUsers();
		for (AdministrativeUser admin : admins) {
			if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				return admin;
			}
		}

		List<Customer> customers = customerService.getAllCustomers();
		for (Customer customer : customers) {
			if (customer.getEmail().equals(email) && customer.getPasswordHash().equals(password)) {
				return customer;
			}
		}

		return "Login failed: Invalid email or password";
	}
}