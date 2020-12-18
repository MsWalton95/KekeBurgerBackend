package com.revautre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

@RestController
@RequestMapping("/users")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping
	public List<Customer> all() {
		return service.getAllCustomer();
	}
	
	@GetMapping("/{email}")
	public Customer byEmail(@PathVariable String email) {
		return service.getByEmail(email);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Customer byId(@PathVariable int id) {
		return service.getById(id);
	} 
	
	@PostMapping
	public HttpStatus add(@RequestBody Customer c) {
		return service.addCustomer(c) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping
	public HttpStatus update(@RequestBody Customer c) {
		return service.updateCustomer(c) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/id")
	public HttpStatus delete(@PathVariable int id) {
		service.deleteCustomer(id);
		return HttpStatus.NO_CONTENT;
	}

}
