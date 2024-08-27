package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ofacms.application.model.Return;
import com.ofacms.application.repository.ReturnRepository;
import com.ofacms.application.service.ReturnService;

@Service
public class ReturnServiceImpl implements ReturnService {

	@Autowired
	private ReturnRepository returnRepository;

	@Override
	public Return saveReturn(Return return1) {
		return returnRepository.save(return1);
	}

	@Override
	public Return getReturnById(int returnId) {
		return returnRepository.findById(returnId);
	}

	@Override
	public List<Return> getAllReturns() {
		return returnRepository.findAll();
	}

	@Override
	public void deleteReturnById(int returnId) {
		returnRepository.delete(returnId);
	}

	@Override
	public Return updateReturn(int returnId, Return return1) {
		if (returnRepository.findById(returnId) != null) {
			return returnRepository.update(return1);
		}
		return null;
	}
}
