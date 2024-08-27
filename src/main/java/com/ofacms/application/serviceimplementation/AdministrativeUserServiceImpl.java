package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.repository.AdministrativeUserRepository;
import com.ofacms.application.service.AdministrativeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministrativeUserServiceImpl implements AdministrativeUserService {

	@Autowired
	private AdministrativeUserRepository administrativeUserRepository;

	@Override
	public AdministrativeUser saveAdministrativeUser(AdministrativeUser administrativeUser) {
		return administrativeUserRepository.save(administrativeUser);
	}

	@Override
	public AdministrativeUser updateAdministrativeUser(int id, AdministrativeUser administrativeUser) {
		if (administrativeUserRepository.findById(id) != null) {
			administrativeUser.setAdminUserId(id);
			return administrativeUserRepository.update(administrativeUser);
		}
		return null;
	}

	@Override
	public void deleteAdministrativeUser(int adminUserId) {
		if (administrativeUserRepository.findById(adminUserId) != null) {
			administrativeUserRepository.delete(adminUserId);
		} else {
			throw new IllegalArgumentException("AdministrativeUser with ID " + adminUserId + " does not exist.");
		}
	}

	@Override
	public AdministrativeUser getAdministrativeUserById(int adminUserId) {
		return administrativeUserRepository.findById(adminUserId);
	}

	@Override
	public List<AdministrativeUser> getAllAdministrativeUsers() {
		return administrativeUserRepository.findAll();
	}

}
