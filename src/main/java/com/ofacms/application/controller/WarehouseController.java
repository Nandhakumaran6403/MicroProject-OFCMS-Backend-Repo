package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.Warehouse;
import com.ofacms.application.service.WarehouseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;

	@GetMapping("/all")
	public List<Warehouse> getAllWarehouses() {
		return warehouseService.getAllWarehouses();
	}

	@GetMapping("/{id}")
	public Warehouse getWarehouseById(@PathVariable int id) {
		return warehouseService.getWarehouseById(id);
	}

	@PostMapping
	public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
		warehouseService.saveWarehouse(warehouse);
		return warehouse;
	}

	@PutMapping("/{id}")
	public Warehouse updateWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
		warehouse.setWarehouseId(id);
		warehouseService.updateWarehouse(id, warehouse);
		return warehouse;
	}

	@DeleteMapping("/{id}")
	public void deleteWarehouse(@PathVariable int id) {
		warehouseService.deleteWarehouseById(id);
	}
}
