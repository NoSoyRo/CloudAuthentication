package com.rincon.taco_cloud.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String fullname;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phone;
  private List<RoleAssignment> rolesAssignments = new ArrayList<>();
  
  public User toUser(PasswordEncoder passwordEncoder) {
	  User user = new User(
		        username, passwordEncoder.encode(password), 
		        fullname, street, city, state, zip, phone);
	  return user;
  }
  
}
