package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Return;

public interface ReturnService {
	Return saveReturn(Return return1);

	Return getReturnById(int returnId);

	List<Return> getAllReturns();

	void deleteReturnById(int returnId);

	Return updateReturn(int returnId, Return return1);
}
