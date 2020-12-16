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
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name", nullable=false, length=20)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=20)
	private String lastName;
	
	@Column(name="email", nullable=false, length=30, unique=true)
	private String email;
	
	@Column(name="phone_number", nullable=false)
	private int phoneNumber;
	
	@OneToMany(mappedBy="address", fetch=FetchType.LAZY, cascade=CascadeType.ALL)  
	private List<String> address;
	
	@OneToOne(mappedBy = "customer", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cart cart;

	public Customer(String firstName, String lastName, String email, int phoneNumber, List<String> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

}
