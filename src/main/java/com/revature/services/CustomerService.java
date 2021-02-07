package com.revature.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Address;
import com.revature.models.Customer;
import com.revature.models.Food;
import com.revature.repositories.AddressRepository;
import com.revature.repositories.CustomerRepository;
import com.revature.repositories.FoodRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private FoodRepository fr;
	
	@Autowired
	private AddressRepository ar;
	
	public Customer login(String email, String password) {
		return cr.findByEmailAndPassword(email, String.valueOf(password.hashCode()));
	}
	
	public void addToOrder(int id1, int id2) {
		Customer c = cr.findById(id1);
		c.getFood().add(fr.findById(id2));
		cr.save(c);
	}
	
	public void removeFromOrder(int id1, int id2) {
		Customer c = cr.findById(id1);
		c.getFood().remove(fr.findById(id2));
		cr.save(c);
	}
	
	public void clearCart(int id) {
		Customer c = cr.findById(id);
		c.getFood().clear();
		cr.save(c);
	}
	
	public int countFood(int id) {
		Customer c = cr.findById(id);
		return c.getFood().size();
	}
	
	public void addFood(int id1, int id2, int quantity) {
		for(int i = 0; i < quantity; i++) {
			addToOrder(id1,id2);
		}
	}
	
	public void removeFood(int id1, int id2, int quantity) {
		for(int i = 0; i < quantity; i++) {
			removeFromOrder(id1,id2);
		}
	}
	
	public List<Customer> getAllCustomers(){
		return (List<Customer>) cr.findAll();
	}
	
	public List<Customer> getPhoneNumber(String number){
		return cr.findByPhoneNumber(number);
	}
	
	public Customer getEmail(String email) {
		return cr.findByEmail(email);
	}
	
	public Customer getCustomer(int id) {
		return cr.findById(id);
	}
	
	public void addCustomer(Customer c) {
		c.setPassword(String.valueOf(c.getPassword().hashCode()));
		cr.save(c);
	}
	
	public void updateFirstName(int id, String firstName) {
		Customer c = cr.findById(id);
		c.setFirstName(firstName);
		cr.save(c);
	}
	
	public void updateLastName(int id, String lastName) {
		Customer c = cr.findById(id);
		c.setLastName(lastName);
		cr.save(c);
	}
	
	public void updateEmail(int id, String email) {
		Customer c = cr.findById(id);
		c.setEmail(email);
		cr.save(c);
	}
	
	public void updatePassword(int id, String password) {
		Customer c = cr.findById(id);
		c.setPassword(String.valueOf(password.hashCode()));
		cr.save(c);
	}
	
	public void updateNumber(int id, String number) {
		Customer c = cr.findById(id);
		c.setPhoneNumber(number);
		cr.save(c);
	}

	public void primaryAddress(int id, int id2) {
		Customer c = cr.findById(id);
		Address a = ar.findById(id2);
		c.setAddress(a);
		cr.save(c);
	}
	
	public void removeCustomer(int id) {
		cr.deleteById(id);
	}
	
	public long countCustomer() {
		return cr.count();
	}
	
	public int quantity(int id, int id2) {
		Customer c = cr.findById(id);
		int qty = Collections.frequency(c.getFood(), fr.findById(id2));
		return qty;
	}
	
	public Set<Food> order(int id){
		Customer c = cr.findById(id);
		Set<Food> food = new HashSet<Food>(c.getFood());
		return food;
	}
	
}
