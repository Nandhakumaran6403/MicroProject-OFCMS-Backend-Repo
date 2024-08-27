package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.model.AuditLog;
import com.ofacms.application.repository.AuditLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class AuditLogServiceImplTest {

    @Mock
    private AuditLogRepository auditLogRepository;

    @InjectMocks
    private AuditLogServiceImpl auditLogService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveAuditLog() {
        Date date = new Date();
        AdministrativeUser user = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AuditLog auditLog = new AuditLog(1, user, "CREATE", date, "Create an Employee");

        when(auditLogRepository.save(any(AuditLog.class))).thenReturn(auditLog);

        AuditLog savedLog = auditLogService.saveAuditLog(auditLog);

        assertNotNull(savedLog);
        assertEquals(auditLog.getLogId(), savedLog.getLogId());
        assertEquals(auditLog.getAction(), savedLog.getAction());
        verify(auditLogRepository, times(1)).save(auditLog);
    }

    @Test
     void testUpdateAuditLog_Success() {
        Date date = new Date();
        AdministrativeUser user = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AuditLog existingLog = new AuditLog(1, user, "CREATE", date, "Create a New Employee");
        AuditLog updatedLog = new AuditLog(1, user, "Update", date, "Update the Employee Details");

        when(auditLogRepository.findById(anyInt())).thenReturn(existingLog);
        when(auditLogRepository.update(any(AuditLog.class))).thenReturn(updatedLog);

        AuditLog resultLog = auditLogService.updateAuditLog(1, updatedLog);

        assertNotNull(resultLog);
        assertEquals(updatedLog.getAction(), resultLog.getAction());
        verify(auditLogRepository, times(1)).update(updatedLog);
    }

    @Test
     void testUpdateAuditLog_Failure() {
        Date date = new Date();
        AdministrativeUser user = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AuditLog auditLog = new AuditLog(1, user, "Create", date, "Create a new Employee");

        when(auditLogRepository.findById(anyInt())).thenReturn(null);

        AuditLog resultLog = auditLogService.updateAuditLog(1, auditLog);

        assertNull(resultLog);
        verify(auditLogRepository, times(0)).update(auditLog);
    }

    @Test
     void testDeleteAuditLog_Success() {
        Date date = new Date();
        AdministrativeUser user = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AuditLog auditLog = new AuditLog(1, user, "CREATE", date, "Create a Employee");

        when(auditLogRepository.findById(anyInt())).thenReturn(auditLog);

        auditLogService.deleteAuditLog(1);

        verify(auditLogRepository, times(1)).delete(1);
    }

    @Test
     void testDeleteAuditLog_Failure() {
        when(auditLogRepository.findById(anyInt())).thenReturn(null);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            auditLogService.deleteAuditLog(1);
        });

        assertEquals("AuditLog with ID 1 does not exist.", thrown.getMessage());
        verify(auditLogRepository, times(0)).delete(1);
    }

    @Test
     void testGetAuditLogById() {
        Date date = new Date();
        AdministrativeUser user = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AuditLog auditLog = new AuditLog(1, user, "CREATE", date, "Create a New Employee");

        when(auditLogRepository.findById(anyInt())).thenReturn(auditLog);

        AuditLog foundLog = auditLogService.getAuditLogById(1);

        assertNotNull(foundLog);
        assertEquals(auditLog.getLogId(), foundLog.getLogId());
        assertEquals(auditLog.getAction(), foundLog.getAction());
        verify(auditLogRepository, times(1)).findById(1);
    }

    @Test
     void testGetAllAuditLogs() {
        Date date = new Date();
        AdministrativeUser user1 = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", date);
        AdministrativeUser user2 = new AdministrativeUser(2, "suriya", "suriya@gmail.com", "password123", "EMPLOYEE", date);
        AuditLog log1 = new AuditLog(1, user1, "CREATE", date, "Create a new employee");
        AuditLog log2 = new AuditLog(2, user2, "DELETE", date, "Delete Retired Employee Details");
        List<AuditLog> logs = Arrays.asList(log1, log2);

        when(auditLogRepository.findAll()).thenReturn(logs);

        List<AuditLog> allLogs = auditLogService.getAllAuditLogs();

        assertNotNull(allLogs);
        assertEquals(2, allLogs.size());
        assertEquals(log1.getLogId(), allLogs.get(0).getLogId());
        assertEquals(log2.getLogId(), allLogs.get(1).getLogId());
        verify(auditLogRepository, times(1)).findAll();
    }
}
