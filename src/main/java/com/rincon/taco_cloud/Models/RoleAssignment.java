package com.rincon.taco_cloud.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table(name = "roles_assignment")
public class RoleAssignment {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
  @ManyToOne
  @JoinColumn(name = "business_user_id")
  private User user;
  public RoleAssignment(Role role, User user) {
	  this.role = role;
	  this.user = user;
  }
}

