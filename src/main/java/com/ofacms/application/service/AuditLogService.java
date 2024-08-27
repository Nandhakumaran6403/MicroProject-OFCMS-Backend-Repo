package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.AuditLog;

public interface AuditLogService {
	AuditLog saveAuditLog(AuditLog auditLog);

	AuditLog getAuditLogById(int logId);

	List<AuditLog> getAllAuditLogs();

	AuditLog updateAuditLog(int id, AuditLog auditLog);

	void deleteAuditLog(int logId);
}
