package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Address;
import com.revature.repositories.AddressRepository;
import com.revature.repositories.CustomerRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository ar;
	
	@Autowired
	private CustomerRepository cr;
	
	public List<Address> getAllAddresses(){
		return (List<Address>) ar.findAll();
	}
	
	public Address getAddress(int id) {
		return ar.findById(id);
	}
	
	public List<Address> getByCustomerId(int id){
		return ar.findByAndCustomerId(id);
	}
	
	public void addAddress(int id, Address a) {
		a.setCustomer(cr.findById(id));
		ar.save(a);
	}
	
	public void updateAddress(int id, Address a) {
		a.setId(id);
		ar.save(a);
	}
	
	public void removeAddress(int id) {
		ar.deleteById(id);
	}
	
	public long countCity(String city) {
		return ar.countByCity(city);
	}
	
	public long countState(String state) {
		return ar.countByState(state);
	}
	
	public long countZipcode(String zipcode) {
		return ar.countByZipcode(zipcode);
	}
}
