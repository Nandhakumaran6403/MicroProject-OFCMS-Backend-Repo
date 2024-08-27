package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Order;
import com.ofacms.application.model.Return;
import com.ofacms.application.repository.ReturnRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class ReturnServiceImplTest {

    @Mock
    private ReturnRepository returnRepository;

    @InjectMocks
    private ReturnServiceImpl returnService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveReturn() {
        Order order = new Order();
        Timestamp returnDate = new Timestamp(System.currentTimeMillis());
        Return returnEntity = new Return(1, order, returnDate, "Reason for return", "Pending");

        when(returnRepository.save(any(Return.class))).thenReturn(returnEntity);

        Return savedReturn = returnService.saveReturn(returnEntity);

        assertNotNull(savedReturn);
        assertEquals(1, savedReturn.getReturnId());
        assertEquals("Reason for return", savedReturn.getReason());
        verify(returnRepository, times(1)).save(returnEntity);
    }

    @Test
    void testGetReturnById() {
        Order order = new Order(); 
        Timestamp returnDate = new Timestamp(System.currentTimeMillis());
        Return returnEntity = new Return(1, order, returnDate, "Reason for return", "Pending");

        when(returnRepository.findById(anyInt())).thenReturn(returnEntity);

        Return retrievedReturn = returnService.getReturnById(1);

        assertNotNull(retrievedReturn);
        assertEquals(1, retrievedReturn.getReturnId());
        assertEquals("Pending", retrievedReturn.getStatus());
        verify(returnRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllReturns() {
        Order order = new Order(); 
        Timestamp returnDate = new Timestamp(System.currentTimeMillis());
        Return return1 = new Return(1, order, returnDate, "Reason 1", "Pending");
        Return return2 = new Return(2, order, returnDate, "Reason 2", "Returned");
        List<Return> returns = Arrays.asList(return1, return2);

        when(returnRepository.findAll()).thenReturn(returns);

        List<Return> result = returnService.getAllReturns();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getReturnId());
        assertEquals(2, result.get(1).getReturnId());
        verify(returnRepository, times(1)).findAll();
    }

    @Test
    void testDeleteReturnById() {
        doNothing().when(returnRepository).delete(anyInt());

        returnService.deleteReturnById(1);

        verify(returnRepository, times(1)).delete(1);
    }

}
