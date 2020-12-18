package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Cart;
import com.revature.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repo;
	
	@Transactional
	public List<Cart> getAllCart() {
		return (List<Cart>) repo.findAll();
	}

	@Transactional 
	public Cart getById(int id) {
		return repo.getOne(id);
	}

	@Transactional
	public boolean updateCart(Cart Cart) {
		return repo.save(Cart) != null;
	}

}
