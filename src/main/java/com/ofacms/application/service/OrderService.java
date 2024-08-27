package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Order;

public interface OrderService {
	Order saveOrder(Order order);

	Order getOrderById(int orderId);

	List<Order> getAllOrders();

	void deleteOrderById(int orderId);

	Order updateOrder(int orderId, Order order);
}
