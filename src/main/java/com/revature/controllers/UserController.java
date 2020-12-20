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

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us;

	@GetMapping("/dummy")
	public List<User> dummy() {
		return us.dummyUsers();
	}
	
	@GetMapping
	public List<User> all() {
		return us.getAllUsers();
	}
	
	
	@GetMapping("/{id}")
	public Optional<User> one(@PathVariable int id) {
		return us.getUser(id);
	}
	
	@PostMapping
	public void add(@RequestBody User u) {
		us.addUser(u);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody User u) {
		us.updateUser(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		us.removeUser(id);
	}
}
