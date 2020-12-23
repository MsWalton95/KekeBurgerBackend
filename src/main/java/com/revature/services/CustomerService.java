package com.revature.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Customer;
import com.revature.repositories.CustomerRepository;
import com.revature.repositories.FoodRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private FoodRepository fr;
	
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
	
	public void updateCustomer(int id, Customer c) {
		c.setId(id);
		cr.save(c);
	}
	
	public void removeCustomer(int id) {
		cr.deleteById(id);
	}
	
	public long countCustomer() {
		return cr.count();
	}
	
}
