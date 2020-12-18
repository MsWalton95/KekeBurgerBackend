package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_id")
	private int id;

	@OneToOne
    @JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="cart", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Food> food;

}
