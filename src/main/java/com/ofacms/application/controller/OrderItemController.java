package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.OrderItem;
import com.ofacms.application.service.OrderItemService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order-items")
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/all")
	public List<OrderItem> getAllOrderItems() {
		return orderItemService.getAllOrderItems();
	}

	@GetMapping("/{id}")
	public OrderItem getOrderItemById(@PathVariable int id) {
		return orderItemService.getOrderItemById(id);
	}

	@PostMapping
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		orderItemService.saveOrderItem(orderItem);
		return orderItem;
	}

	@PutMapping("/{id}")
	public OrderItem updateOrderItem(@PathVariable int id, @RequestBody OrderItem orderItem) {
		orderItem.setOrderItemId(id);
		orderItemService.updateOrderItem(id, orderItem);
		return orderItem;
	}

	@DeleteMapping("/{id}")
	public void deleteOrderItem(@PathVariable int id) {
		orderItemService.deleteOrderItemById(id);
	}
}
