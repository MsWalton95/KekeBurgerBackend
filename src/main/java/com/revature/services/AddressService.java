package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Address;

@Service
public class AddressService {
	
	private List<Address> addresses = new ArrayList<>(Arrays.asList(
			new Address(1,"1660 Peachtree St. NE", null, "Atlanta","GA", 30309),
			new Address(2,"4420 Peach Drive. NE", "Unit 201", "Savannah","GA", 30010)
			));
	
	public List<Address> getAllAddresses(){
		return addresses;
	}
	
	public Address getAddress(int id) {
		return addresses.get(id-1);
	}
	
	public void addAddress(Address a) {
		addresses.add(a);
	}
	
	public void updateAddress(int id, Address u) {
		addresses.set(id-1, u);
	}
	
	public void removeAddress(int id) {
		addresses.remove(id-1);
	}
}
