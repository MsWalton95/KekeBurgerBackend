package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name="users")
public class User {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@OneToMany(mappedBy="user")
	private Address address;
	
	@OneToOne
	private Cart cart;
	
	public User(String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
}
