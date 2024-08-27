package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.Warehouse;
import com.ofacms.application.repository.WarehouseRepository;
import com.ofacms.application.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Override
	public Warehouse saveWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	@Override
	public Warehouse getWarehouseById(int warehouseId) {
		return warehouseRepository.findById(warehouseId);
	}

	@Override
	public List<Warehouse> getAllWarehouses() {
		return warehouseRepository.findAll();
	}

	@Override
	public void deleteWarehouseById(int warehouseId) {
		warehouseRepository.delete(warehouseId);
	}

	@Override
	public Warehouse updateWarehouse(int warehouseId, Warehouse warehouse) {
		if (warehouseRepository.findById(warehouseId) != null) {
			warehouse.setWarehouseId(warehouseId);
			return warehouseRepository.update(warehouse);
		}
		return null;
	}
}
