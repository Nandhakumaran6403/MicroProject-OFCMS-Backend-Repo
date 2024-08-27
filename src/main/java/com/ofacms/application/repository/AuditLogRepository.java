package com.ofacms.application.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ofacms.application.model.AuditLog;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AuditLogRepository {

	@Autowired
	EntityManager entityManager;

	public AuditLog findById(int id) {
		return entityManager.find(AuditLog.class, id);
	}

	public List<AuditLog> findAll() {
		return entityManager.createQuery("SELECT c FROM AuditLog c", AuditLog.class).getResultList();
	}

	public AuditLog save(AuditLog auditLog) {
		entityManager.persist(auditLog);
		return auditLog;
	}

	public AuditLog update(AuditLog auditLog) {
		return entityManager.merge(auditLog);
	}

	public void delete(int id) {
		AuditLog auditLog = findById(id);
		if (auditLog != null) {
			entityManager.remove(auditLog);
		}
	}

}
