package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Inventory;

import java.util.List;

@Repository
@Transactional
public class InventoryRepository {

	@Autowired
	private EntityManager entityManager;

	public Inventory findById(int id) {
		return entityManager.find(Inventory.class, id);
	}

	public List<Inventory> findAll() {
		return entityManager.createQuery("SELECT i FROM Inventory i", Inventory.class).getResultList();
	}

	public Inventory save(Inventory inventory) {
		entityManager.persist(inventory);
		return inventory;
	}

	public Inventory update(Inventory inventory) {
		entityManager.merge(inventory);
		return inventory;
	}

	public void delete(int id) {
		Inventory inventory = findById(id);
		if (inventory != null) {
			entityManager.remove(inventory);
		}
	}
}
