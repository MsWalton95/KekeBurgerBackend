package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public Customer findById(int id);
	
	public Customer findByEmail(String email);
	
	public Customer findByEmailAndPassword(String email, String password);
	
	public List<Customer> findByPhoneNumber(String number);

}
