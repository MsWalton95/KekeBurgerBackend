package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Address;

public interface IAddressDAO extends JpaRepository<Address, Integer>{

}
