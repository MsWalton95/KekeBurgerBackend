package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByEmail(String email);
	
//	@Query("SELECT c FROM Customer c WHERE c.address = (SELECT a.address_id FROM Address a WHERE a.city = ?1)" )
//	public List<Customer> findbyCity(String city);
//	
//	@Query("SELECT c FROM Customer c WHERE c.address = (SELECT a.address_id FROM Address a WHERE a.state = ?1)" )
//	public List<Customer> findbyState(String state);
//	
//	@Query("SELECT c FROM Customer c WHERE c.address = (SELECT a.address_id FROM Address a WHERE a.zipcode = ?1)" )
//	public List<Customer> findbyZipCode(String zipcode);
}
