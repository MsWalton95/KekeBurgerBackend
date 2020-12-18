package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="first_name", nullable=false, length=20)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=20)
	private String lastName;
	
	@Column(name="email", nullable=false, length=30, unique=true)
	private String email;
	
	@Column(name="phone_number", nullable=false)
	private long phoneNumber;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Address> address;

	@OneToOne(mappedBy="customer",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Cart cart;

}
