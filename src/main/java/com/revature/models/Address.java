package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Address {
	
	@Id
	private int id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipcode;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id", nullable = false)
	private User user;

	public Address(String address1, String address2, String city, String state, int zipcode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
}
