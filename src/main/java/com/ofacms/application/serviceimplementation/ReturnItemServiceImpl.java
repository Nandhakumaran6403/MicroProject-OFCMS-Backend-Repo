package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.ReturnItem;
import com.ofacms.application.repository.ReturnItemRepository;
import com.ofacms.application.service.ReturnItemService;

@Service
public class ReturnItemServiceImpl implements ReturnItemService {

	@Autowired
	private ReturnItemRepository returnItemRepository;

	@Override
	public ReturnItem saveReturnItem(ReturnItem returnItem) {
		return returnItemRepository.save(returnItem);
	}

	@Override
	public ReturnItem getReturnItemById(int returnItemId) {
		return returnItemRepository.findById(returnItemId);
	}

	@Override
	public List<ReturnItem> getAllReturnItems() {
		return returnItemRepository.findAll();
	}

	@Override
	public void deleteReturnItemById(int returnItemId) {
		returnItemRepository.delete(returnItemId);
	}

	@Override
	public ReturnItem updateReturnItem(int returnItemId, ReturnItem returnItem) {
		if (returnItemRepository.findById(returnItemId) != null) {
			returnItem.setReturnItemId(returnItemId);
			return returnItemRepository.update(returnItem);
		}
		return null;
	}
}
