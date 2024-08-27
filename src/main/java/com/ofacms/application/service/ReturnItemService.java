package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.ReturnItem;

public interface ReturnItemService {
	ReturnItem saveReturnItem(ReturnItem returnItem);

	ReturnItem getReturnItemById(int returnItemId);

	List<ReturnItem> getAllReturnItems();

	void deleteReturnItemById(int returnItemId);

	ReturnItem updateReturnItem(int returnItemId, ReturnItem returnItem);
}
