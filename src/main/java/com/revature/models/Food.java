package com.revature.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="food_id")
	private int foodId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="calories", nullable=false)
	private int calories;
	
	@ManyToOne(cascade=CascadeType.ALL, optional=true)
	@JoinColumn(name="cart_id")
	private Cart cart;

}
