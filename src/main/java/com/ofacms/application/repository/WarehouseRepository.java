package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Warehouse;

import java.util.List;

@Repository
@Transactional
public class WarehouseRepository {

	@Autowired
	private EntityManager entityManager;

	public Warehouse findById(int id) {
		return entityManager.find(Warehouse.class, id);
	}

	public List<Warehouse> findAll() {
		return entityManager.createQuery("SELECT w FROM Warehouse w", Warehouse.class).getResultList();
	}

	public Warehouse save(Warehouse warehouse) {
		entityManager.persist(warehouse);
		return warehouse;
	}

	public Warehouse update(Warehouse warehouse) {
		return entityManager.merge(warehouse);
	}

	public void delete(int id) {
		Warehouse warehouse = findById(id);
		if (warehouse != null) {
			entityManager.remove(warehouse);
		}
	}
}
