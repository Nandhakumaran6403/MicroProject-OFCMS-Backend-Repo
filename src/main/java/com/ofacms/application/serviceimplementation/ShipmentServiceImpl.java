package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.Shipment;
import com.ofacms.application.repository.ShipmentRepository;
import com.ofacms.application.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public Shipment saveShipment(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public Shipment getShipmentById(int shipmentId) {
		return shipmentRepository.findById(shipmentId);
	}

	@Override
	public List<Shipment> getAllShipments() {
		return shipmentRepository.findAll();
	}

	@Override
	public void deleteShipmentById(int shipmentId) {
		shipmentRepository.delete(shipmentId);
	}

	@Override
	public Shipment updateShipment(int shipmentId, Shipment shipment) {
		if (shipmentRepository.findById(shipmentId) != null) {
			shipment.setShipmentId(shipmentId);
			return shipmentRepository.update(shipment);
		}
		return null;
	}
}
