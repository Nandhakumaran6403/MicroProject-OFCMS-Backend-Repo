package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Shipment;

public interface ShipmentService {
	Shipment saveShipment(Shipment shipment);

	Shipment getShipmentById(int shipmentId);

	List<Shipment> getAllShipments();

	void deleteShipmentById(int shipmentId);

	Shipment updateShipment(int shipmentId, Shipment shipment);
}
