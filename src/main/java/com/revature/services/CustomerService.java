package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Customer;
import com.revature.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Transactional
	public List<Customer> getAllCustomer() {
		return (List<Customer>) repo.findAll();
	}

	@Transactional
	public Customer getByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Transactional 
	public Customer getById(int id) {
		return repo.getOne(id);
	}

	@Transactional
	public boolean addCustomer(Customer c) {
		return repo.save(c) != null;
	}

	@Transactional
	public boolean updateCustomer(Customer c) {
		return repo.save(c) != null;
	}
	
	@Transactional
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}
}
