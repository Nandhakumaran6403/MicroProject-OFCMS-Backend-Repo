package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.ReturnItem;

import java.util.List;

@Repository
@Transactional
public class ReturnItemRepository {

	@Autowired
	private EntityManager entityManager;

	public ReturnItem findById(int id) {
		return entityManager.find(ReturnItem.class, id);
	}

	public List<ReturnItem> findAll() {
		return entityManager.createQuery("SELECT ri FROM ReturnItem ri", ReturnItem.class).getResultList();
	}

	public ReturnItem save(ReturnItem returnItem) {
		entityManager.persist(returnItem);
		return returnItem;
	}

	public ReturnItem update(ReturnItem returnItem) {
		return entityManager.merge(returnItem);
	}

	public void delete(int id) {
		ReturnItem returnItem = findById(id);
		if (returnItem != null) {
			entityManager.remove(returnItem);
		}
	}
}
