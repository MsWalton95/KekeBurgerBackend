package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Food;
import com.revature.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repo;
	
	@Transactional
	public List<Food> getAllFood(){
		return repo.findAll();
	}
	
	@Transactional
	public List<Food> getByType(String type){
		return repo.findByType(type);
	}
	
	@Transactional
	public Food getByName(String name) {
		return repo.findByName(name);
	}
	
	@Transactional
	public Food getById(int id) {
		return repo.getOne(id);
	}
	
	@Transactional
	public boolean addFood(Food f) {
		return repo.save(f) != null;
	}
	
	@Transactional
	public boolean updateFood(Food f) {
		return repo.save(f) != null;
	}
	
	@Transactional
	public void deleteFood(int id) {
		repo.deleteById(id);
	}
}
