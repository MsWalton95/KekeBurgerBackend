package com.revautre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.Food;
import com.revature.services.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	FoodService service;
	
	@GetMapping
	public List<Food> findAll(){
		return service.getAllFood();
	}
	
	@GetMapping
	public List<Food> findType(String type){
		return service.getByType(type);
	}
	
	@GetMapping
	public Food findName(String name) {
		return service.getByName(name);
	}
	
	@GetMapping
	public Food findId(int id) {
		return service.getById(id);
	}
	
	@PostMapping
	public HttpStatus add(Food f) {
		return service.addFood(f) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping
	public HttpStatus update(Food f) {
		return service.updateFood(f) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping
	public HttpStatus delete(int id) {
		service.deleteFood(id);
		return HttpStatus.NO_CONTENT;
	}

}
