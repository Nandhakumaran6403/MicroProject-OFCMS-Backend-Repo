package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofacms.application.model.Customer;
import com.ofacms.application.repository.CustomerRepository;
import com.ofacms.application.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomerById(int customerId) {
		customerRepository.delete(customerId);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		if (customerRepository.findById(customerId) != null) {
			customer.setCustomerId(customerId);
			return customerRepository.update(customer);
		}
		return null;
	}
}
