package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@GetMapping
	public List<Customer> all() {
		return cs.getAllCustomers();
	}
	
	@PostMapping("/login")
	public Customer login(@RequestBody Customer c) {
		return cs.login(c.getEmail(), c.getPassword());
	}
	
	@PutMapping("/{id}/add/{food}")
	public void addOrder(@PathVariable int id, @PathVariable int food) {
		cs.addToOrder(id, food);
	}
	
	@PutMapping("/{id}/remove/{food}")
	public void removeOrder(@PathVariable int id, @PathVariable int food) {
		cs.removeFromOrder(id, food);
	}
	
	@PostMapping
	public void add(@RequestBody Customer u) {
		cs.addCustomer(u);
	}
	
	@GetMapping("/{id}")
	public Customer one(@PathVariable int id) {
		return cs.getCustomer(id);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Customer u) {
		cs.updateCustomer(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		cs.removeCustomer(id);
	}
	
	@GetMapping("/count")
	public long count() {
		return cs.countCustomer();
	}
	
	@GetMapping("/number/{number}")
	public List<Customer> number(@PathVariable String number){
		return cs.getPhoneNumber(number);
	}
	
	@GetMapping("/email/{email}")
	public Customer email(@PathVariable String email) {
		return cs.getEmail(email);
	}
}
