package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Cart;

public interface ICartDAO extends JpaRepository<Cart, Integer>{

}
