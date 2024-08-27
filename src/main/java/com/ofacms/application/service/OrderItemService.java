package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.OrderItem;

public interface OrderItemService {
	OrderItem saveOrderItem(OrderItem orderItem);

	OrderItem getOrderItemById(int orderItemId);

	List<OrderItem> getAllOrderItems();

	void deleteOrderItemById(int orderItemId);

	OrderItem updateOrderItem(int orderItemId, OrderItem orderItem);
}
