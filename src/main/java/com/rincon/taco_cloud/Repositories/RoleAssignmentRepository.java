package com.rincon.taco_cloud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.rincon.taco_cloud.Models.RoleAssignment;

public interface RoleAssignmentRepository extends CrudRepository<RoleAssignment, Long> {

	  RoleAssignment findByRoleId(Integer roleId);
	  RoleAssignment findByUserId(Integer userId);
	  
}