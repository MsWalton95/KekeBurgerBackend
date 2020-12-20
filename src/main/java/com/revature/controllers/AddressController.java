package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Address;
import com.revature.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService as;
	
	@GetMapping("/dummy")
	public List<Address> dummy() {
		return as.dummyAddresses();
	}
	
	@GetMapping
	public List<Address> all() {
		return as.getAllAddresses();
	}
	
	@GetMapping("/{id}")
	public Optional<Address> one(@PathVariable int id) {
		return as.getAddress(id);
	}
	
	@PostMapping
	public void add(@RequestBody Address a) {
		as.addAddress(a);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Address a) {
		as.updateAddress(id, a);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		as.removeAddress(id);
	}
}
