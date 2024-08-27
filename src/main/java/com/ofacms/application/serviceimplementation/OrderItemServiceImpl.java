package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.OrderItem;
import com.ofacms.application.repository.OrderItemRepository;
import com.ofacms.application.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem getOrderItemById(int orderItemId) {
		return orderItemRepository.findById(orderItemId);
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}

	@Override
	public void deleteOrderItemById(int orderItemId) {
		orderItemRepository.delete(orderItemId);
	}

	@Override
	public OrderItem updateOrderItem(int orderItemId, OrderItem orderItem) {
		if (orderItemRepository.findById(orderItemId) != null) {
			orderItem.setOrderItemId(orderItemId);
			return orderItemRepository.update(orderItem);
		}
		return null;
	}
}
