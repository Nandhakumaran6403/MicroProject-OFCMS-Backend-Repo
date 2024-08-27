package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.OrderItem;

import java.util.List;

@Repository
@Transactional
public class OrderItemRepository {

	@Autowired
	private EntityManager entityManager;

	public OrderItem findById(int id) {
		return entityManager.find(OrderItem.class, id);
	}

	public List<OrderItem> findAll() {
		return entityManager.createQuery("SELECT oi FROM OrderItem oi", OrderItem.class).getResultList();
	}

	public OrderItem save(OrderItem orderItem) {
		entityManager.persist(orderItem);
		return orderItem;
	}

	public OrderItem update(OrderItem orderItem) {
		entityManager.merge(orderItem);
		return orderItem;
	}

	public void delete(int id) {
		OrderItem orderItem = findById(id);
		if (orderItem != null) {
			entityManager.remove(orderItem);
		}
	}
}
