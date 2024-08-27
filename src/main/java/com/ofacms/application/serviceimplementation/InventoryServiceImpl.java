package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ofacms.application.model.Inventory;
import com.ofacms.application.repository.InventoryRepository;
import com.ofacms.application.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override

	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory getInventoryById(int inventoryId) {
		return inventoryRepository.findById(inventoryId);
	}

	@Override
	public List<Inventory> getAllInventories() {
		return inventoryRepository.findAll();
	}

	@Override
	public void deleteInventoryById(int inventoryId) {
		inventoryRepository.delete(inventoryId);
	}

	@Override

	public Inventory updateInventory(int inventoryId, Inventory inventory) {
		if (inventoryRepository.findById(inventoryId) != null) {
			inventory.setInventoryId(inventoryId);
			return inventoryRepository.update(inventory);
		}
		return null;
	}
}
