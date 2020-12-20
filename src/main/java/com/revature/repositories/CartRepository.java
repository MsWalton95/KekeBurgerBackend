package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {}
