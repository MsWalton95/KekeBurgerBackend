package com.revature.controllers;

import java.util.List;

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
	
	@GetMapping
	public List<Address> all() {
		return as.getAllAddresses();
	}
	
	@GetMapping("/{id}")
	public Address one(@PathVariable int id) {
		return as.getAddress(id);
	}
	
	@PostMapping("/{id}")
	public void add(@PathVariable int id, @RequestBody Address a) {
		as.addAddress(id, a);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Address a) {
		as.updateAddress(id, a);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		as.removeAddress(id);
	}
	
	@GetMapping("/city/{city}")
	public long city(@PathVariable String city) {
		return as.countCity(city);
	}
	
	@GetMapping("/state/{state}")
	public long state(@PathVariable String state) {
		return as.countState(state);
	}
	
	@GetMapping("/zipcode/{zipcode}")
	public long zipcode(@PathVariable String zipcode) {
		return as.countZipcode(zipcode);
	}
	
}
