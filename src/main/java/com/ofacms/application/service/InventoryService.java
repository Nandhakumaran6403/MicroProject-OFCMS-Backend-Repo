package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Inventory;

public interface InventoryService {
	Inventory saveInventory(Inventory inventory);

	Inventory getInventoryById(int inventoryId);

	List<Inventory> getAllInventories();

	void deleteInventoryById(int inventoryId);

	Inventory updateInventory(int inventoryId, Inventory inventory);
}
