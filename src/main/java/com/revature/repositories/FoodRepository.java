package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {}
