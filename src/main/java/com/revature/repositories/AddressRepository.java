package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	public Address findById(int id);
	
	public long countByCity(String city);
	
	public long countByState(String state);
	
	public long countByZipcode(String zipcode);
	
	public List<Address> findByAndCustomerId(int id);

}
