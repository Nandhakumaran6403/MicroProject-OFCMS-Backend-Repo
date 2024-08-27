package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.Order;
import com.ofacms.application.repository.OrderRepository;
import com.ofacms.application.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(int orderId) {
		return orderRepository.findById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrderById(int orderId) {
		orderRepository.delete(orderId);
	}

	@Override
	public Order updateOrder(int orderId, Order order) {
		if (orderRepository.findById(orderId) != null) {
			order.setOrderId(orderId);
			return orderRepository.update(order);
		}
		return null;
	}
}
