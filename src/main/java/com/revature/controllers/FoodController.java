package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService fs;
	
	@GetMapping
	public List<Food> all() {
		return fs.getAllFoods();
	}
	
	@PostMapping
	public void add(@RequestBody Food f) {
		fs.addFood(f);
	}
	
	@GetMapping("/{id}")
	public Food one(@PathVariable int id) {
		return fs.getFood(id);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Food f) {
		fs.updateFood(id, f);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		fs.removeFood(id);
	}
	
	@GetMapping("/count")
	public long count(){
		return fs.countFood();
	}
	
	@GetMapping("/name/{name}")
	public Food name(@PathVariable String name) {
		return fs.getName(name);
	}

	@GetMapping("/type/{type}")
	public List<Food> type(@PathVariable String type){
		return fs.getType(type);
	}
}
