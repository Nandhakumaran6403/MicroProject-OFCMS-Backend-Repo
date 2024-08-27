package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.Shipment;
import com.ofacms.application.service.ShipmentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/shipments")
public class ShipmentController {
	@Autowired
	private ShipmentService shipmentService;

	@GetMapping("/all")
	public List<Shipment> getAllShipments() {
		return shipmentService.getAllShipments();
	}

	@GetMapping("/{id}")
	public Shipment getShipmentById(@PathVariable int id) {
		return shipmentService.getShipmentById(id);
	}

	@PostMapping
	public Shipment createShipment(@RequestBody Shipment shipment) {
		shipmentService.saveShipment(shipment);
		return shipment;
	}

	@PutMapping("/{id}")
	public Shipment updateShipment(@PathVariable int id, @RequestBody Shipment shipment) {
		shipment.setShipmentId(id);
		shipmentService.updateShipment(id, shipment);
		return shipment;
	}

	@DeleteMapping("/{id}")
	public void deleteShipment(@PathVariable int id) {
		shipmentService.deleteShipmentById(id);
	}
}
