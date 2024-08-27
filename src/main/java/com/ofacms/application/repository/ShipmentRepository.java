package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Shipment;

import java.util.List;

@Repository
@Transactional
public class ShipmentRepository {

	@Autowired
	private EntityManager entityManager;

	public Shipment findById(int id) {
		return entityManager.find(Shipment.class, id);
	}

	public List<Shipment> findAll() {
		return entityManager.createQuery("SELECT s FROM Shipment s", Shipment.class).getResultList();
	}

	public Shipment save(Shipment shipment) {
		entityManager.persist(shipment);
		return shipment;
	}

	public Shipment update(Shipment shipment) {
		return entityManager.merge(shipment);
	}

	public void delete(int id) {
		Shipment shipment = findById(id);
		if (shipment != null) {
			entityManager.remove(shipment);
		}
	}
}
