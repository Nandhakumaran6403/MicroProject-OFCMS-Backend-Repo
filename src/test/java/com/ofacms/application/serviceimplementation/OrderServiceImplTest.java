package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Customer;
import com.ofacms.application.model.Order;
import com.ofacms.application.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrder() {
        Customer customer = new Customer(); 
        Order order = new Order(1, customer, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.saveOrder(order);

        assertNotNull(savedOrder);
        assertEquals(order.getOrderId(), savedOrder.getOrderId());
        assertEquals(order.getTotalAmount(), savedOrder.getTotalAmount());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testGetOrderById() {
        Customer customer = new Customer(); 
        Order order = new Order(1, customer, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");

        when(orderRepository.findById(anyInt())).thenReturn(order);

        Order foundOrder = orderService.getOrderById(1);

        assertNotNull(foundOrder);
        assertEquals(order.getOrderId(), foundOrder.getOrderId());
        assertEquals(order.getTotalAmount(), foundOrder.getTotalAmount());
        verify(orderRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllOrders() {
        Customer customer1 = new Customer();
        Order order1 = new Order(1, customer1, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");

        Customer customer2 = new Customer(); 
        Order order2 = new Order(2, customer2, LocalDateTime.now(), "Shipped", BigDecimal.valueOf(150.0), "UPI", "Pending");

        List<Order> orders = Arrays.asList(order1, order2);

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> allOrders = orderService.getAllOrders();

        assertNotNull(allOrders);
        assertEquals(2, allOrders.size());
        assertEquals(order1.getOrderId(), allOrders.get(0).getOrderId());
        assertEquals(order2.getOrderId(), allOrders.get(1).getOrderId());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testDeleteOrderById() {
        Customer customer = new Customer(); 
        Order order = new Order(1, customer, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");

        when(orderRepository.findById(anyInt())).thenReturn(order);

        orderService.deleteOrderById(1);

        verify(orderRepository, times(1)).delete(1);
    }

    @Test
    void testUpdateOrder_Success() {
        Customer customer = new Customer();
        Order existingOrder = new Order(1, customer, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");
        Order updatedOrder = new Order(1, customer, LocalDateTime.now(), "Delivered", BigDecimal.valueOf(150.0), "Credit Card", "Paid");

        when(orderRepository.findById(anyInt())).thenReturn(existingOrder);
        when(orderRepository.update(any(Order.class))).thenReturn(updatedOrder);

        Order resultOrder = orderService.updateOrder(1, updatedOrder);

        assertNotNull(resultOrder);
        assertEquals(updatedOrder.getStatus(), resultOrder.getStatus());
        assertEquals(updatedOrder.getTotalAmount(), resultOrder.getTotalAmount());
        verify(orderRepository, times(1)).update(updatedOrder);
    }

    @Test
    void testUpdateOrder_Failure() {
        Customer customer = new Customer(); 
        Order order = new Order(1, customer, LocalDateTime.now(), "Processing", BigDecimal.valueOf(100.0), "Credit Card", "Paid");

        when(orderRepository.findById(anyInt())).thenReturn(null);

        Order resultOrder = orderService.updateOrder(1, order);

        assertNull(resultOrder);
        verify(orderRepository, times(0)).update(order);
    }
}
