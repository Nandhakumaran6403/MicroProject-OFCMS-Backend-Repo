package com.ofacms.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductRepository {

	@Autowired
	private EntityManager entityManager;

	public void save(Product product){

		entityManager.persist(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Query query = entityManager.createQuery("from Product");
		return query.getResultList();
	}

	public Product findById(int id) {
		return entityManager.find(Product.class, id);
	}

	public void deleteById(int id) {
		Product product = entityManager.find(Product.class, id);
		if (product != null) {
			entityManager.remove(product);
		}
	}

	public void update(Product product) {
		entityManager.persist(product);
	}
}
