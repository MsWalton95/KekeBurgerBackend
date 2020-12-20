package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Food;
import com.revature.repositories.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository fr;
	
	private List<Food> foods = new ArrayList<Food>(Arrays.asList(
			new Food(1, "MacBurger", 5.99, "Burger", 1500),
			new Food(2, "MacShake", 3.99, "Shake", 1600)
			));
	
	public List<Food> dummyFood(){
		return foods;
	}
	
	public List<Food> getAllFoods(){
		return (List<Food>) fr.findAll();
	}
	
	public Optional<Food> getFood(int id) {
		return fr.findById(id);
	}
	
	public void addFood(Food f) {
		fr.save(f);
	}
	
	public void updateFood(int id, Food f) {
		fr.save(f);
	}
	
	public void removeFood(int id) {
		fr.deleteById(id);
	}
}
