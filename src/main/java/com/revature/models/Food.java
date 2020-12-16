package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Food implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="food_id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="calories", nullable=false)
	private int calories;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Cart cart;

	public Food(String name, double price, String type, int calories) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.calories = calories;
	}
	
}
