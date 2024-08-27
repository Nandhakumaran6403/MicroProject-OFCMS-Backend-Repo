package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.ReturnItem;
import com.ofacms.application.service.ReturnItemService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/return-items")
public class ReturnItemController {
	@Autowired
	private ReturnItemService returnItemService;

	@GetMapping("/all")
	public List<ReturnItem> getAllReturnItems() {
		return returnItemService.getAllReturnItems();
	}

	@GetMapping("/{id}")
	public ReturnItem getReturnItemById(@PathVariable int id) {
		return returnItemService.getReturnItemById(id);
	}

	@PostMapping
	public ReturnItem createReturnItem(@RequestBody ReturnItem returnItem) {
		returnItemService.saveReturnItem(returnItem);
		return returnItem;
	}

	@PutMapping("/{id}")
	public ReturnItem updateReturnItem(@PathVariable int id, @RequestBody ReturnItem returnItem) {
		returnItem.setReturnItemId(id);
		returnItemService.updateReturnItem(id, returnItem);
		return returnItem;
	}

	@DeleteMapping("/{id}")
	public void deleteReturnItem(@PathVariable int id) {
		returnItemService.deleteReturnItemById(id);
	}
}
