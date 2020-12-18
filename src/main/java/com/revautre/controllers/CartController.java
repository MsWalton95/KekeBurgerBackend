package com.revautre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Cart;
import com.revature.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService service;
	
	@GetMapping
	public List<Cart> all(){
		return service.getAllCart();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Cart byId(@PathVariable int id) {
		return service.getById(id);
	} 
	
	@PutMapping
	public HttpStatus update(@RequestBody Cart c) {
		return service.updateCart(c) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

}
