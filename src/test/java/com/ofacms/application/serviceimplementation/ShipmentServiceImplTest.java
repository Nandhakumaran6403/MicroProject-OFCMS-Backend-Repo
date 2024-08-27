package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.OrderItem;
import com.ofacms.application.model.Shipment;
import com.ofacms.application.repository.ShipmentRepository;
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

 class ShipmentServiceImplTest {

    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveShipment() {
        OrderItem orderItem = new OrderItem();
        Timestamp shipmentDate = new Timestamp(System.currentTimeMillis());
        Shipment shipment = new Shipment(1, orderItem, shipmentDate, "123456", "DHL", "Shipped");

        when(shipmentRepository.save(any(Shipment.class))).thenReturn(shipment);

        Shipment savedShipment = shipmentService.saveShipment(shipment);

        assertNotNull(savedShipment);
        assertEquals(1, savedShipment.getShipmentId());
        assertEquals("DHL", savedShipment.getCorrier());
        verify(shipmentRepository, times(1)).save(shipment);
    }

    @Test
    void testGetShipmentById() {
        OrderItem orderItem = new OrderItem(); 
        Timestamp shipmentDate = new Timestamp(System.currentTimeMillis());
        Shipment shipment = new Shipment(1, orderItem, shipmentDate, "123456", "DHL", "Shipped");

        when(shipmentRepository.findById(anyInt())).thenReturn(shipment);

        Shipment retrievedShipment = shipmentService.getShipmentById(1);

        assertNotNull(retrievedShipment);
        assertEquals(1, retrievedShipment.getShipmentId());
        assertEquals("Shipped", retrievedShipment.getStatus());
        verify(shipmentRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllShipments() {
        OrderItem orderItem = new OrderItem(); 
        Timestamp shipmentDate = new Timestamp(System.currentTimeMillis());
        Shipment shipment1 = new Shipment(1, orderItem, shipmentDate, "123456", "DHL", "Shipped");
        Shipment shipment2 = new Shipment(2, orderItem, shipmentDate, "789012", "FedEx", "Delivered");
        List<Shipment> shipments = Arrays.asList(shipment1, shipment2);

        when(shipmentRepository.findAll()).thenReturn(shipments);

        List<Shipment> result = shipmentService.getAllShipments();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getShipmentId());
        assertEquals(2, result.get(1).getShipmentId());
        verify(shipmentRepository, times(1)).findAll();
    }

    @Test
    void testDeleteShipmentById() {
        doNothing().when(shipmentRepository).delete(anyInt());

        shipmentService.deleteShipmentById(1);

        verify(shipmentRepository, times(1)).delete(1);
    }

    
}
