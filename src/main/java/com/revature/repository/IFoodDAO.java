package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Food;

public interface IFoodDAO extends JpaRepository<Food, Integer>{

}
