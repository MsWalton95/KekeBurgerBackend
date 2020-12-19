package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<>( Arrays.asList(
			new User(1, "Keke","Watson","kewatson95@gmail.com", "9321237890"),
			new User(2, "Bob", "Blecher", "boblecher79@gmail.com", "5071598462")
			));
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUser(int id) {
		return users.get(id-1);
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public void updateUser(int id, User u) {
		users.set(id-1, u);
	}
	
	public void removeUser(int id) {
		users.remove(id-1);
	}
	
}
