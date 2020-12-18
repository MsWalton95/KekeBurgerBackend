package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
//	@Query("SELECT city, COUNT(*) FROM address WHERE city = ?1 GROUP BY city")
//	public List<Address> countByCity(String city);
//	
//	@Query("SELECT state, COUNT(*) FROM address WHERE state = ?1 GROUP BY state")
//	public List<Address> countByState(String state);
//	
//	@Query("SELECT zipcode, COUNT(*) FROM address WHERE zipcode = ?1 GROUP BY zipcode")
//	public List<Address> countByZipcode(String zipcode);
}
