package com.ofacms.application.repository;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.repository.AdministrativeUserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AdministrativeUserRepository {

	@Autowired
	EntityManager entityManager;

	public AdministrativeUser findById(int id) {
		return entityManager.find(AdministrativeUser.class, id);
	}

	public List<AdministrativeUser> findAll() {
		return entityManager.createQuery("SELECT c FROM AdministrativeUser c", AdministrativeUser.class)
				.getResultList();
	}

	public AdministrativeUser save(AdministrativeUser administrativeUser) {
		entityManager.persist(administrativeUser);
		return administrativeUser;
	}

	public AdministrativeUser update(AdministrativeUser administrativeUser) {
		entityManager.merge(administrativeUser);
		return administrativeUser;
	}

	public void delete(int id) {
		AdministrativeUser administrativeUser = findById(id);
		if (administrativeUser != null) {
			entityManager.remove(administrativeUser);
		}
	}
}
