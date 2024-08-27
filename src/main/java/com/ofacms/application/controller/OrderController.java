package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.Order;
import com.ofacms.application.service.OrderService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/all")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}

	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
		order.setOrderId(id);
		orderService.updateOrder(id, order);
		return order;
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrderById(id);
	}
}
