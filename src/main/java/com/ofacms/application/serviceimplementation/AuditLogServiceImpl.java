package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.AuditLog;
import com.ofacms.application.repository.AuditLogRepository;
import com.ofacms.application.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

	@Autowired
	private AuditLogRepository auditLogRepository;

	@Override
	public AuditLog saveAuditLog(AuditLog auditLog) {
		return auditLogRepository.save(auditLog);
	}

	@Override
	public AuditLog updateAuditLog(int id, AuditLog auditLog) {
		if (auditLogRepository.findById(id) != null) {
			auditLog.setLogId(id);
			return auditLogRepository.update(auditLog);
		}
		return null;
	}

	@Override
	public void deleteAuditLog(int logId) {
		if (auditLogRepository.findById(logId) != null) {
			auditLogRepository.delete(logId);
		} else {
			throw new IllegalArgumentException("AuditLog with ID " + logId + " does not exist.");
		}
	}

	@Override
	public AuditLog getAuditLogById(int logId) {
		return auditLogRepository.findById(logId);
	}

	@Override
	public List<AuditLog> getAllAuditLogs() {
		return auditLogRepository.findAll();
	}
}
