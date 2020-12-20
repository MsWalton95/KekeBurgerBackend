package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	private List<User> foods = new ArrayList<>(Arrays.asList(
			new User(1,"Keke","Watson","kewatson95@gmail.com","7326785430"),
			new User(2,"Bob","Blecher","boblecher78@gmail.com","8085558080")
			));
	
	public List<User> dummyUsers(){
		return foods;
	}
	
	public List<User> getAllUsers(){
		return (List<User>) ur.findAll();
	}
	
	public Optional<User> getUser(int id) {
		return ur.findById(id);
	}
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public void updateUser(int id, User u) {
		ur.save(u);
	}
	
	public void removeUser(int id) {
		ur.deleteById(id);
	}
	
}
