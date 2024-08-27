package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Customer;

import java.util.List;

@Repository
@Transactional
public class CustomerRepository {

	@Autowired
	private EntityManager entityManager;

	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}

	public List<Customer> findAll() {
		return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}

	public Customer save(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	public Customer update(Customer customer) {
		return entityManager.merge(customer);
	}

	public void delete(int id) {
		Customer customer = findById(id);
		if (customer != null) {
			entityManager.remove(customer);
		}
	}

}
