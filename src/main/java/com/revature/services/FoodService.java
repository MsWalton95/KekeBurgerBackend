package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Food;
import com.revature.repositories.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository fr;
	
	public List<Food> getAllFoods(){
		return (List<Food>) fr.findAll();
	}
	
	public List<Food> getType(String type) {
		return fr.findByType(type);
	}
	
	public long countFood(){
		return fr.count();
	}
	
	public Food getFood(int id) {
		return fr.findById(id);
	}
	
	public Food getName(String name) {
		return fr.findByName(name);
	}
	
	public void addFood(Food f) {
		fr.save(f);
	}
	
	public void updateFood(int id, Food f) {
		f.setId(id);
		fr.save(f);
	}
	
	public void removeFood(int id) {
		fr.deleteById(id);
	}
}
