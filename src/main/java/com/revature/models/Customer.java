package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=20)
	private String firstName;
	
	@Column(nullable=false, length=20)
	private String lastName;
	
	@Column(nullable=false, unique=true, length=30)
	private String email;
	
	@Column(nullable=false, length=15)
	private String password;
	
	@Column(nullable=false, length=10)
	private String phoneNumber;
	
	@Column(nullable=true)
	private boolean subscribed;
	
	@ManyToMany
    @JoinTable(name="Cart", 
                joinColumns={@JoinColumn(name="customer_id")}, 
                inverseJoinColumns={@JoinColumn(name="food_id")})
	private List<Food> food;
	
	@OneToOne
	private Address address;
	
	public Customer(String firstName, String lastName, String email, String password, String phoneNumber, boolean subscribed) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.subscribed = subscribed;
	}

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Customer(String update) {
		super();
	}	
	
}
