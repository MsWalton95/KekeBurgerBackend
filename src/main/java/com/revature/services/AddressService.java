package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Address;
import com.revature.repository.AddressRepository;

public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	@Transactional
	public List<Address> getAllAddress(){
		return repo.findAll();
	}
	
	@Transactional
	public Address getById(int id) {
		return repo.getOne(id);
	}
	
	@Transactional
	public boolean addAddress(Address a) {
		return repo.save(a) !=null;
	}
	
	@Transactional
	public boolean updateAddress(Address a) {
		return repo.save(a) != null;
	}
	
	@Transactional
	public void deleteAddress(int id) {
		repo.deleteById(id);
	}

}
