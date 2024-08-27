package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.OrderItem;
import com.ofacms.application.model.Return;
import com.ofacms.application.model.ReturnItem;
import com.ofacms.application.repository.ReturnItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class ReturnItemServiceImplTest {

    @Mock
    private ReturnItemRepository returnItemRepository;

    @InjectMocks
    private ReturnItemServiceImpl returnItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveReturnItem() {
        Return returnItem = new Return(); 
        OrderItem orderItem = new OrderItem(); 
        ReturnItem returnItemEntity = new ReturnItem(1, returnItem, orderItem, 2);

        when(returnItemRepository.save(any(ReturnItem.class))).thenReturn(returnItemEntity);

        ReturnItem savedReturnItem = returnItemService.saveReturnItem(returnItemEntity);

        assertNotNull(savedReturnItem);
        assertEquals(1, savedReturnItem.getReturnItemId());
        verify(returnItemRepository, times(1)).save(returnItemEntity);
    }

    @Test
    void testGetReturnItemById() {
        Return returnItem = new Return(); 
        OrderItem orderItem = new OrderItem();
        ReturnItem returnItemEntity = new ReturnItem(1, returnItem, orderItem, 2);

        when(returnItemRepository.findById(anyInt())).thenReturn(returnItemEntity);

        ReturnItem retrievedReturnItem = returnItemService.getReturnItemById(1);

        assertNotNull(retrievedReturnItem);
        assertEquals(1, retrievedReturnItem.getReturnItemId());
        verify(returnItemRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllReturnItems() {
        Return returnItem = new Return(); 
        OrderItem orderItem = new OrderItem();
        ReturnItem returnItem1 = new ReturnItem(1, returnItem, orderItem, 2);
        ReturnItem returnItem2 = new ReturnItem(2, returnItem, orderItem, 5);
        List<ReturnItem> returnItems = Arrays.asList(returnItem1, returnItem2);

        when(returnItemRepository.findAll()).thenReturn(returnItems);

        List<ReturnItem> result = returnItemService.getAllReturnItems();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getReturnItemId());
        assertEquals(2, result.get(1).getReturnItemId());
        verify(returnItemRepository, times(1)).findAll();
    }

    @Test
    void testDeleteReturnItemById() {
        doNothing().when(returnItemRepository).delete(anyInt());

        returnItemService.deleteReturnItemById(1);

        verify(returnItemRepository, times(1)).delete(1);
    }

}
