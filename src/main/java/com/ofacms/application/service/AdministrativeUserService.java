package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.AdministrativeUser;

public interface AdministrativeUserService {
	AdministrativeUser saveAdministrativeUser(AdministrativeUser user);

	AdministrativeUser getAdministrativeUserById(int userId);

	List<AdministrativeUser> getAllAdministrativeUsers();

	void deleteAdministrativeUser(int userId);

	AdministrativeUser updateAdministrativeUser(int id, AdministrativeUser user);

}
