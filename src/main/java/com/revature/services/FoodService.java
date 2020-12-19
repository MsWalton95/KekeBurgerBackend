package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Food;

@Service
public class FoodService {

	private List<Food> foods = new ArrayList<Food>(Arrays.asList(
			new Food(1, "MacBurger", 5.99, "Burger", 1500),
			new Food(2, "MacShake", 3.99, "Shake", 1600)
			));
	
	public List<Food> getAllFoods(){
		return foods;
	}
	
	public Food getFood(int id) {
		return foods.get(id-1);
	}
	
	public void addFood(Food f) {
		foods.add(f);
	}
	
	public void updateFood(int id, Food f) {
		foods.set(id-1, f);
	}
	
	public void removeFood(int id) {
		foods.remove(id-1);
	}
}
