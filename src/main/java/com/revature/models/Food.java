package com.revature.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Food {
	private int id;
	private String name;
	private double price;
	private String type;
	private int calories;

	
	public Food(String name, double price, String type, int calories) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.calories = calories;
	}

	
}
