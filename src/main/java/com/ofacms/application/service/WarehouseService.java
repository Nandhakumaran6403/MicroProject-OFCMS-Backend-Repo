package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Warehouse;

public interface WarehouseService {
	Warehouse saveWarehouse(Warehouse warehouse);

	Warehouse getWarehouseById(int warehouseId);

	List<Warehouse> getAllWarehouses();

	void deleteWarehouseById(int warehouseId);

	Warehouse updateWarehouse(int warehouseId, Warehouse warehouse);
}
