package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Warehouse;
import com.ofacms.application.repository.WarehouseRepository;
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

 class WarehouseServiceImplTest {

    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseServiceImpl warehouseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveWarehouse() {
        Warehouse warehouse = new Warehouse(1, "Main Warehouse", "Location A", "Nandha", "123-456-7890");

        when(warehouseRepository.save(any(Warehouse.class))).thenReturn(warehouse);

        Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouse);

        assertNotNull(savedWarehouse);
        assertEquals(1, savedWarehouse.getWarehouseId());
        assertEquals("Main Warehouse", savedWarehouse.getWarehouseName());
        verify(warehouseRepository, times(1)).save(warehouse);
    }

    @Test
    void testGetWarehouseById() {
        Warehouse warehouse = new Warehouse(1, "Main Warehouse", "Location A", "Nandha", "123-456-7890");

        when(warehouseRepository.findById(anyInt())).thenReturn(warehouse);

        Warehouse retrievedWarehouse = warehouseService.getWarehouseById(1);

        assertNotNull(retrievedWarehouse);
        assertEquals(1, retrievedWarehouse.getWarehouseId());
        assertEquals("Location A", retrievedWarehouse.getLocation());
        verify(warehouseRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllWarehouses() {
        Warehouse warehouse1 = new Warehouse(1, "Main Warehouse", "Location A", "Nandha", "123-456-7890");
        Warehouse warehouse2 = new Warehouse(2, "Secondary Warehouse", "Location B", "Suriya", "987-654-3210");
        List<Warehouse> warehouses = Arrays.asList(warehouse1, warehouse2);

        when(warehouseRepository.findAll()).thenReturn(warehouses);

        List<Warehouse> result = warehouseService.getAllWarehouses();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getWarehouseId());
        assertEquals("Secondary Warehouse", result.get(1).getWarehouseName());
        verify(warehouseRepository, times(1)).findAll();
    }

    @Test
    void testDeleteWarehouseById() {
        doNothing().when(warehouseRepository).delete(anyInt());

        warehouseService.deleteWarehouseById(1);

        verify(warehouseRepository, times(1)).delete(1);
    }

}
