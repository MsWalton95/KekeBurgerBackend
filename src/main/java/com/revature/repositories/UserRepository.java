package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;

import com.revature.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
