package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Order;
import com.ofacms.application.model.OrderItem;
import com.ofacms.application.model.Product;
import com.ofacms.application.repository.OrderItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class OrderItemServiceImplTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testSaveOrderItem() {
        Order order = new Order(); 
        Product product = new Product(); 
        OrderItem orderItem = new OrderItem(1, order, product, 2, BigDecimal.valueOf(50.0));

        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);

        assertNotNull(savedOrderItem);
        assertEquals(orderItem.getOrderItemId(), savedOrderItem.getOrderItemId());
        assertEquals(orderItem.getPrice(), savedOrderItem.getPrice());
        verify(orderItemRepository, times(1)).save(orderItem);
    }

    @Test
     void testGetOrderItemById() {
        Order order = new Order(); 
        Product product = new Product(); 
        OrderItem orderItem = new OrderItem(1, order, product, 2, BigDecimal.valueOf(50.0));

        when(orderItemRepository.findById(anyInt())).thenReturn(orderItem);

        OrderItem foundOrderItem = orderItemService.getOrderItemById(1);

        assertNotNull(foundOrderItem);
        assertEquals(orderItem.getOrderItemId(), foundOrderItem.getOrderItemId());
        assertEquals(orderItem.getPrice(), foundOrderItem.getPrice());
        verify(orderItemRepository, times(1)).findById(1);
    }

    @Test
     void testGetAllOrderItems() {
        Order order1 = new Order(); 
        Product product1 = new Product(); 
        OrderItem orderItem1 = new OrderItem(1, order1, product1, 2, BigDecimal.valueOf(50.0));

        Order order2 = new Order(); 
        Product product2 = new Product(); 
        OrderItem orderItem2 = new OrderItem(2, order2, product2, 3, BigDecimal.valueOf(75.0));

        List<OrderItem> orderItems = Arrays.asList(orderItem1, orderItem2);

        when(orderItemRepository.findAll()).thenReturn(orderItems);

        List<OrderItem> allOrderItems = orderItemService.getAllOrderItems();

        assertNotNull(allOrderItems);
        assertEquals(2, allOrderItems.size());
        assertEquals(orderItem1.getOrderItemId(), allOrderItems.get(0).getOrderItemId());
        assertEquals(orderItem2.getOrderItemId(), allOrderItems.get(1).getOrderItemId());
        verify(orderItemRepository, times(1)).findAll();
    }

    @Test
     void testDeleteOrderItemById() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(1, order, product, 2, BigDecimal.valueOf(50.0));

        when(orderItemRepository.findById(anyInt())).thenReturn(orderItem);

        orderItemService.deleteOrderItemById(1);

        verify(orderItemRepository, times(1)).delete(1);
    }

    @Test
     void testUpdateOrderItem_Success() {
        Order order = new Order(); 
        Product product = new Product();
        OrderItem existingOrderItem = new OrderItem(1, order, product, 2, BigDecimal.valueOf(50.0));
        OrderItem updatedOrderItem = new OrderItem(1, order, product, 3, BigDecimal.valueOf(75.0));

        when(orderItemRepository.findById(anyInt())).thenReturn(existingOrderItem);
        when(orderItemRepository.update(any(OrderItem.class))).thenReturn(updatedOrderItem);

        OrderItem resultOrderItem = orderItemService.updateOrderItem(1, updatedOrderItem);

        assertNotNull(resultOrderItem);
        assertEquals(updatedOrderItem.getQuantity(), resultOrderItem.getQuantity());
        assertEquals(updatedOrderItem.getPrice(), resultOrderItem.getPrice());
        verify(orderItemRepository, times(1)).update(updatedOrderItem);
    }

    @Test
     void testUpdateOrderItem_Failure() {
        Order order = new Order(); 
        Product product = new Product();
        OrderItem orderItem = new OrderItem(1, order, product, 2, BigDecimal.valueOf(50.0));

        when(orderItemRepository.findById(anyInt())).thenReturn(null);

        OrderItem resultOrderItem = orderItemService.updateOrderItem(1, orderItem);

        assertNull(resultOrderItem);
        verify(orderItemRepository, times(0)).update(orderItem);
    }
}
