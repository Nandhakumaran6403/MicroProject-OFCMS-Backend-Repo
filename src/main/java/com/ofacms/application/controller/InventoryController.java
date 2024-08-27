package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.Inventory;
import com.ofacms.application.service.InventoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/all")
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventories();
	}

	@GetMapping("/{id}")
	public Inventory getInventoryById(@PathVariable int id) {
		return inventoryService.getInventoryById(id);
	}

	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		inventoryService.saveInventory(inventory);
		return inventory;
	}

	@PutMapping("/{id}")
	public Inventory updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
		inventory.setInventoryId(id);
		inventoryService.updateInventory(id, inventory);
		return inventory;
	}

	@DeleteMapping("/{id}")
	public void deleteInventory(@PathVariable int id) {
		inventoryService.deleteInventoryById(id);
	}
}
