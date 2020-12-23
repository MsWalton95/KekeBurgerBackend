package com.revature.models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Food implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String name;
	@Column(nullable=false)
	private double price;
	@Column(nullable=false)
	private String type;
	@Column(nullable=false)
	private int calories;
	private String description;
	@Column(unique=true)
	private String image;
	
	public Food(String name, double price, String type, int calories) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.calories = calories;
	}
	
	public Food(String name, double price, String type, int calories, String description, String image) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.calories = calories;
		this.description = description;
		this.image = image;
	}
}
