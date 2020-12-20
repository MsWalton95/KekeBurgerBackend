package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Address;
import com.revature.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository ar;
	
	private List<Address> addresses = new ArrayList<>(Arrays.asList(
			new Address(1,"1660 Peachtree St. NE", null, "Atlanta","GA", 30309),
			new Address(2,"4420 Peach Drive. NE", "Unit 201", "Savannah","GA", 30010)
			));
	
	public List<Address> dummyAddresses(){
		return addresses;
	}
	
	public List<Address> getAllAddresses(){
		return (List<Address>) ar.findAll();
	}
	
	public Optional<Address> getAddress(int id) {
		return ar.findById(id);
	}
	
	public void addAddress(Address a) {
		ar.save(a);
	}
	
	public void updateAddress(int id, Address a) {
		ar.save(a);
	}
	
	public void removeAddress(int id) {
		ar.deleteById(id);
	}
}
