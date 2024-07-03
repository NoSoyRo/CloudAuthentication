package com.rincon.taco_cloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.rincon.taco_cloud.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	  User findByBusinessUserName(String username);
	  
}
