package com.ofacms.application.controller;

import com.ofacms.application.model.AuditLog;
import com.ofacms.application.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @PostMapping
    public AuditLog createAuditLog(@RequestBody AuditLog auditLog) {
        return auditLogService.saveAuditLog(auditLog);
    }

    @PutMapping("/{id}")
    public AuditLog updateAuditLog(@PathVariable("id") int id, @RequestBody AuditLog auditLog) {
        if (auditLog.getLogId() != id) {
            throw new IllegalArgumentException("AuditLog ID mismatch");
        }
        return auditLogService.updateAuditLog(id,auditLog);
    }

    @DeleteMapping("/{id}")
    public void deleteAuditLog(@PathVariable("id") int id) {
        auditLogService.deleteAuditLog(id);
    }

    @GetMapping("/{id}")
    public AuditLog getAuditLogById(@PathVariable("id") int id) {
    	return auditLogService.getAuditLogById(id);
    }

    @GetMapping("/all")
    public List<AuditLog> getAllAuditLogs() {
        return auditLogService.getAllAuditLogs();
    }
    
   
}

