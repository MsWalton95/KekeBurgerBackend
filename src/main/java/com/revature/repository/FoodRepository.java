package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	public Food findByName(String name);
	
	public List<Food> findByType(String type);
}
