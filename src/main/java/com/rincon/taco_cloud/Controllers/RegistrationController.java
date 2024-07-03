package com.rincon.taco_cloud.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rincon.taco_cloud.Models.RegistrationForm;
import com.rincon.taco_cloud.Models.Role;
import com.rincon.taco_cloud.Models.RoleAssignment;
import com.rincon.taco_cloud.Models.User;
import com.rincon.taco_cloud.Repositories.RoleAssignmentRepository;
import com.rincon.taco_cloud.Repositories.RoleRepository;
import com.rincon.taco_cloud.Repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleAssignmentRepository roleAssignmentRepo;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

  public RegistrationController(
      UserRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }
  
  @GetMapping
  public String registerForm() {
    return "registration";
  }
  
  @PostMapping
  public String processRegistration(RegistrationForm form) {
	  User user = form.toUser(passwordEncoder);
	  userRepo.save(user);
	  //logic to update services
	  Long userId = (long) 1;
	  Optional<Role> role = roleRepository.findById(userId);
	  if (role!= null) {
		  RoleAssignment roleAssignment = new RoleAssignment(role.get(), user);
	  	  roleAssignmentRepo.save(roleAssignment);
	  }
    return "redirect:/login";
  }

}
