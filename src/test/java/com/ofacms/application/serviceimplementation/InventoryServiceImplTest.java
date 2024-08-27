package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Inventory;
import com.ofacms.application.model.Product;
import com.ofacms.application.model.Warehouse;
import com.ofacms.application.repository.InventoryRepository;
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

 class InventoryServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveInventory() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product(); 
        Warehouse warehouse = new Warehouse(); 
        Inventory inventory = new Inventory(1, product, warehouse, 100, now);

        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        Inventory savedInventory = inventoryService.saveInventory(inventory);

        assertNotNull(savedInventory);
        assertEquals(inventory.getInventoryId(), savedInventory.getInventoryId());
        assertEquals(inventory.getQuantity(), savedInventory.getQuantity());
        verify(inventoryRepository, times(1)).save(inventory);
    }

    @Test
     void testGetInventoryById() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product(); 
        Warehouse warehouse = new Warehouse();
        Inventory inventory = new Inventory(1, product, warehouse, 100, now);

        when(inventoryRepository.findById(anyInt())).thenReturn(inventory);

        Inventory foundInventory = inventoryService.getInventoryById(1);

        assertNotNull(foundInventory);
        assertEquals(inventory.getInventoryId(), foundInventory.getInventoryId());
        assertEquals(inventory.getQuantity(), foundInventory.getQuantity());
        verify(inventoryRepository, times(1)).findById(1);
    }

    @Test
     void testGetAllInventories() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product1 = new Product();
        Warehouse warehouse1 = new Warehouse(); 
        Inventory inventory1 = new Inventory(1, product1, warehouse1, 100, now);
        
        Product product2 = new Product(); 
        Warehouse warehouse2 = new Warehouse();
        Inventory inventory2 = new Inventory(2, product2, warehouse2, 200, now);
        
        List<Inventory> inventories = Arrays.asList(inventory1, inventory2);

        when(inventoryRepository.findAll()).thenReturn(inventories);

        List<Inventory> allInventories = inventoryService.getAllInventories();

        assertNotNull(allInventories);
        assertEquals(2, allInventories.size());
        assertEquals(inventory1.getInventoryId(), allInventories.get(0).getInventoryId());
        assertEquals(inventory2.getInventoryId(), allInventories.get(1).getInventoryId());
        verify(inventoryRepository, times(1)).findAll();
    }

    @Test
     void testDeleteInventoryById() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product();
        Warehouse warehouse = new Warehouse(); 
        Inventory inventory = new Inventory(1, product, warehouse, 100, now);

        when(inventoryRepository.findById(anyInt())).thenReturn(inventory);

        inventoryService.deleteInventoryById(1);

        verify(inventoryRepository, times(1)).delete(1);
    }

    @Test
     void testUpdateInventory_Success() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product();
        Warehouse warehouse = new Warehouse();
        Inventory existingInventory = new Inventory(1, product, warehouse, 100, now);
        Inventory updatedInventory = new Inventory(1, product, warehouse, 150, now);

        when(inventoryRepository.findById(anyInt())).thenReturn(existingInventory);
        when(inventoryRepository.update(any(Inventory.class))).thenReturn(updatedInventory);

        Inventory resultInventory = inventoryService.updateInventory(1, updatedInventory);

        assertNotNull(resultInventory);
        assertEquals(updatedInventory.getQuantity(), resultInventory.getQuantity());
        verify(inventoryRepository, times(1)).update(updatedInventory);
    }

    @Test
     void testUpdateInventory_Failure() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product();
        Warehouse warehouse = new Warehouse();
        Inventory inventory = new Inventory(1, product, warehouse, 100, now);

        when(inventoryRepository.findById(anyInt())).thenReturn(null);

        Inventory resultInventory = inventoryService.updateInventory(1, inventory);

        assertNull(resultInventory);
        verify(inventoryRepository, times(0)).update(inventory);
    }
}
