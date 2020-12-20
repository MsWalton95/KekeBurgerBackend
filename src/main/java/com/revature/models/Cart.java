package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cart {
	
	@Id
	private int id;
	
	@OneToOne
	private User user;
	
	@OneToMany
	private List<Food> foods;
}
