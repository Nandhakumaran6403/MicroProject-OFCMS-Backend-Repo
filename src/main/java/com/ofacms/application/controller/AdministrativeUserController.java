package com.ofacms.application.controller;

import com.ofacms.application.model.AdministrativeUser;
import com.ofacms.application.service.AdministrativeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin-users")
public class AdministrativeUserController {

	@Autowired
	private AdministrativeUserService administrativeUserService;

	@PostMapping
	public AdministrativeUser createAdministrativeUser(@RequestBody AdministrativeUser administrativeUser) {
		return administrativeUserService.saveAdministrativeUser(administrativeUser);
	}

	@PutMapping("/{id}")
	public AdministrativeUser updateAdministrativeUser(@PathVariable("id") int id,
			@RequestBody AdministrativeUser administrativeUser) {
		if (administrativeUser.getAdminUserId() != id) {
			throw new IllegalArgumentException("AdministrativeUser ID mismatch");
		}
		return administrativeUserService.updateAdministrativeUser(id, administrativeUser);
	}

	@DeleteMapping("/{id}")
	public void deleteAdministrativeUser(@PathVariable("id") int id) {
		administrativeUserService.deleteAdministrativeUser(id);
	}

	@GetMapping("/{id}")
	public AdministrativeUser getAdministrativeUserById(@PathVariable("id") int id) {
		return administrativeUserService.getAdministrativeUserById(id);
	}

	@GetMapping("/all")
	public List<AdministrativeUser> getAllAdministrativeUsers() {
		return administrativeUserService.getAllAdministrativeUsers();
	}

	@PatchMapping("/lastlogin/{id}")
	public AdministrativeUser updateLastLoginDate(@PathVariable("id") int id) {
		AdministrativeUser user = administrativeUserService.getAdministrativeUserById(id);
		if (user != null) {
			user.setLastLoginDate(new Date());
			return administrativeUserService.updateAdministrativeUser(id, user);
		}
		return null;
	}
}
