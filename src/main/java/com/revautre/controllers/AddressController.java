package com.revautre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Address;
import com.revature.services.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService service;
	
	@RequestMapping
	public List<Address> all() {
		return service.getAllAddress();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Address byId(@PathVariable int id) {
		return service.getById(id);
	} 
	
	@PostMapping
	public HttpStatus add(@RequestBody Address c) {
		return service.addAddress(c) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping
	public HttpStatus update(@RequestBody Address c) {
		return service.updateAddress(c) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/id")
	public HttpStatus delete(@PathVariable int id) {
		service.deleteAddress(id);
		return HttpStatus.NO_CONTENT;
	}
}
