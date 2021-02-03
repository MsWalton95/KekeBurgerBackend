package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Customer;
import com.revature.models.Food;
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
	
	@PutMapping("/{id}/add/{food}/{quantity}")
	public void addToOrder(@PathVariable int id, @PathVariable int food, @PathVariable int quantity) {
		cs.addFood(id, food, quantity);
	}
	
	@PutMapping("/{id}/remove/{food}")
	public void removeOrder(@PathVariable int id, @PathVariable int food) {
		cs.removeFromOrder(id, food);
	}
	
	@PutMapping("/{id}/remove/{food}/{quantity}")
	public void removeFromOrder(@PathVariable int id, @PathVariable int food, @PathVariable int quantity) {
		cs.removeFood(id, food, quantity);
	}
	
	@GetMapping("/{id}/clear")
	public void clearCart(@PathVariable int id) {
		cs.clearCart(id);
	}
	
	@GetMapping("/{id}/count")
	public int countFood(@PathVariable int id) {
		return cs.countFood(id);
	}
	
	@GetMapping("/{id}/food")
	public Set<Food> setFood(@PathVariable int id) {
		return cs.order(id);
	}
	
	@GetMapping("/{id}/count/{food}")
	public int quantity(@PathVariable int id, @PathVariable int food) {
		return cs.quantity(id, food);
	}
	
	@PostMapping
	public void add(@RequestBody Customer u) {
		cs.addCustomer(u);
	}
	
	@GetMapping("/{id}")
	public Customer one(@PathVariable int id) {
		return cs.getCustomer(id);
	}
	@PatchMapping("/{id}/firstName")
	public void updateFirstName(@PathVariable int id, @RequestBody Customer c) {
		cs.updateFirstName(id, c.getFirstName());
	}
	@PatchMapping("/{id}/lastName")
	public void updateLastName(@PathVariable int id, @RequestBody Customer c) {
		cs.updateLastName(id, c.getLastName());
	}
	
	@PatchMapping("/{id}/email")
	public void updateEmail(@PathVariable int id, @RequestBody Customer c) {
		cs.updateEmail(id, c.getEmail());
	}
	
	@PatchMapping("/{id}/password")
	public void updatePassword(@PathVariable int id, @RequestBody Customer c) {
		cs.updatePassword(id, c.getPassword());
	}
	
	@PatchMapping("/{id}/number")
	public void updateNumber(@PathVariable int id, @RequestBody Customer c) {
		cs.updateNumber(id, c.getPhoneNumber());
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
