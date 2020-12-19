package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Address {
	private int id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipcode;

	public Address(String address1, String address2, String city, String state, int zipcode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
}
