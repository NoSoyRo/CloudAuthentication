package com.rincon.taco_cloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.rincon.taco_cloud.Models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	  Role findByNameRole(String nameRole);
	  
}