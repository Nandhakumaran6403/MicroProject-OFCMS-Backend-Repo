package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Order;

import java.util.List;

@Repository
@Transactional
public class OrderRepository {

	@Autowired
	private EntityManager entityManager;

	public Order findById(int id) {
		return entityManager.find(Order.class, id);
	}

	public List<Order> findAll() {
		return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
	}

	public Order save(Order order) {
		entityManager.persist(order);
		return order;
	}

	public Order update(Order order) {
		entityManager.merge(order);
		return order;
	}

	public void delete(int id) {
		Order order = findById(id);
		if (order != null) {
			entityManager.remove(order);
		}
	}
}
