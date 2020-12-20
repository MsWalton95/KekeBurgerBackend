package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {
	
	public Food findById(int id);
	
	public Food findByName(String name);
	
	public List<Food> findByType(String type);
	
	public List<Food> countByName(String name);
}
