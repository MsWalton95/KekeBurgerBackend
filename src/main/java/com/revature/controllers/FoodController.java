package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Food;
import com.revature.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService fs;
	
	@GetMapping("/dummy")
	public List<Food> dummy() {
		return fs.dummyFood();
	}
	
	@GetMapping
	public List<Food> all() {
		return fs.getAllFoods();
	}
	
	@GetMapping("/{id}")
	public Optional<Food> one(@PathVariable int id) {
		return fs.getFood(id);
	}
	
	@PostMapping
	public void add(@RequestBody Food f) {
		fs.addFood(f);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Food f) {
		fs.updateFood(id, f);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		fs.removeFood(id);
	}
}
