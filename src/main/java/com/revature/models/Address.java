package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String address1;
	
	@Column(nullable=false, length=20)
	private String city;
	
	@Column(nullable=false, length=2)
	private String state;
	
	@Column(nullable=false, length=5)
	private String zipcode;
	
	private double lat;
	private double lng;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;

	public Address(String address1, String city, String state, String zipcode) {
		super();
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Address(int id, String address1, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Address(String address1, String city, String state, String zipcode, double lat, double lng) {
		super();
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.lat = lat;
		this.lng = lng;
	}
	
}
