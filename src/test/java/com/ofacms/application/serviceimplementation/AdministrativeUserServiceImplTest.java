package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.repository.AdministrativeUserRepository;
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

 class AdministrativeUserServiceImplTest {

    @Mock
    private AdministrativeUserRepository administrativeUserRepository;

    @InjectMocks
    private AdministrativeUserServiceImpl administrativeUserService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveAdministrativeUser() {
        Date lastLoginDate = new Date();
        AdministrativeUser administrativeUser = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);
        when(administrativeUserRepository.save(any(AdministrativeUser.class))).thenReturn(administrativeUser);

        AdministrativeUser savedUser = administrativeUserService.saveAdministrativeUser(administrativeUser);

        assertNotNull(savedUser);
        assertEquals(administrativeUser.getAdminUserId(), savedUser.getAdminUserId());
        verify(administrativeUserRepository, times(1)).save(administrativeUser);
    }

    @Test
     void testUpdateAdministrativeUser_Success() {
        Date lastLoginDate = new Date();
        AdministrativeUser existingUser = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);
        AdministrativeUser updatedUser = new AdministrativeUser(1, "nandha", "nandhakumaran@gmail.com", "newpassword", "EMPLOYEE", lastLoginDate);

        when(administrativeUserRepository.findById(anyInt())).thenReturn(existingUser);
        when(administrativeUserRepository.update(any(AdministrativeUser.class))).thenReturn(updatedUser);

        AdministrativeUser resultUser = administrativeUserService.updateAdministrativeUser(1, updatedUser);

        assertNotNull(resultUser);
        assertEquals(updatedUser.getEmail(), resultUser.getEmail());
        assertEquals(updatedUser.getPassword(), resultUser.getPassword());
        verify(administrativeUserRepository, times(1)).update(updatedUser);
    }

    @Test
     void testUpdateAdministrativeUser_Failure() {
        Date lastLoginDate = new Date();
        AdministrativeUser administrativeUser = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);

        when(administrativeUserRepository.findById(anyInt())).thenReturn(null);

        AdministrativeUser resultUser = administrativeUserService.updateAdministrativeUser(1, administrativeUser);

        assertNull(resultUser);
        verify(administrativeUserRepository, times(0)).update(administrativeUser);
    }

    @Test
     void testGetAdministrativeUserById() {
        Date lastLoginDate = new Date();
        AdministrativeUser administrativeUser = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);
        when(administrativeUserRepository.findById(anyInt())).thenReturn(administrativeUser);

        AdministrativeUser foundUser = administrativeUserService.getAdministrativeUserById(1);

        assertNotNull(foundUser);
        assertEquals(administrativeUser.getAdminUserId(), foundUser.getAdminUserId());
        verify(administrativeUserRepository, times(1)).findById(1);
    }

    @Test
     void testGetAllAdministrativeUsers() {
        Date lastLoginDate = new Date();
        AdministrativeUser user1 = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);
        AdministrativeUser user2 = new AdministrativeUser(2, "suriya", "suriya@gmail.com", "password123", "EMPLOYEE", lastLoginDate);
        List<AdministrativeUser> users = Arrays.asList(user1, user2);

        when(administrativeUserRepository.findAll()).thenReturn(users);

        List<AdministrativeUser> allUsers = administrativeUserService.getAllAdministrativeUsers();

        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertEquals(user1.getAdminUserId(), allUsers.get(0).getAdminUserId());
        assertEquals(user2.getAdminUserId(), allUsers.get(1).getAdminUserId());
        verify(administrativeUserRepository, times(1)).findAll();
    }

    @Test
     void testDeleteAdministrativeUser_Success() {
        Date lastLoginDate = new Date();
        AdministrativeUser administrativeUser = new AdministrativeUser(1, "nandha", "nandha@gmail.com", "password", "ADMIN", lastLoginDate);

        when(administrativeUserRepository.findById(anyInt())).thenReturn(administrativeUser);

        administrativeUserService.deleteAdministrativeUser(1);

        verify(administrativeUserRepository, times(1)).delete(1);
    }

    @Test
     void testDeleteAdministrativeUser_Failure() {
        when(administrativeUserRepository.findById(anyInt())).thenReturn(null);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            administrativeUserService.deleteAdministrativeUser(1);
        });

        assertEquals("AdministrativeUser with ID 1 does not exist.", thrown.getMessage());
        verify(administrativeUserRepository, times(0)).delete(1);
    }
}
