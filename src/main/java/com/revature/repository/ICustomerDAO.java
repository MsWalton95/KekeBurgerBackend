package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Customer;

public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

}
