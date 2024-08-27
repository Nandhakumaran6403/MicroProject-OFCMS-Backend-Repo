package com.ofacms.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Return;

import java.util.List;

@Repository
@Transactional
public class ReturnRepository {

	@Autowired
	private EntityManager entityManager;

	public Return findById(int id) {
		return entityManager.find(Return.class, id);
	}

	public List<Return> findAll() {
		return entityManager.createQuery("SELECT r FROM Return r", Return.class).getResultList();
	}

	public Return save(Return return1) {
		entityManager.persist(return1);
		return return1;
	}

	public Return update(Return return1) {
		return entityManager.merge(return1);
	}

	public void delete(int id) {
		Return return1 = findById(id);
		if (return1 != null) {
			entityManager.remove(return1);
		}
	}
}
