package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofacms.application.model.Return;
import com.ofacms.application.service.ReturnService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/returns")
public class ReturnController {
	@Autowired
	private ReturnService returnService;

	@GetMapping("/all")
	public List<Return> getAllReturns() {
		return returnService.getAllReturns();
	}

	@GetMapping("/{id}")
	public Return getReturnById(@PathVariable int id) {
		return returnService.getReturnById(id);
	}

	@PostMapping
	public Return createReturn(@RequestBody Return return1) {
		returnService.saveReturn(return1);
		return return1;
	}

	@PutMapping("/{id}")
	public Return updateReturn(@PathVariable int id, @RequestBody Return return1) {
		return1.setReturnId(id);
		return returnService.updateReturn(id, return1);

	}

	@DeleteMapping("/{id}")
	public void deleteReturn(@PathVariable int id) {
		returnService.deleteReturnById(id);
	}
}
