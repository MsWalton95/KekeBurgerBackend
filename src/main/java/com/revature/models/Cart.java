package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="cart", fetch=FetchType.LAZY)
	private List<Food> food;

	public Cart(Customer customer, List<Food> food) {
		super();
		this.customer = customer;
		this.food = food;
	}
	
}
