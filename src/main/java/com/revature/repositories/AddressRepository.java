package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {}
