package com.rincon.taco_cloud.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name = "usuarios")
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name = "business_user_name")
  private final String businessUserName;
  @Column(name = "password")
  private final String password;
  @Column(name = "full_name")
  private final String fullName;
  @Column(name = "street")
  private final String street;
  @Column(name = "city")
  private final String city;
  @Column(name = "state")
  private final String state;
  @Column(name = "zip")
  private final String zip;
  @Column(name = "phone_number")
  private final String phoneNumber;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<RoleAssignment> rolesAssignments;
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
	  List<GrantedAuthority> authorities = new ArrayList<>();
      for (RoleAssignment role : rolesAssignments) {
          authorities.add(new SimpleGrantedAuthority(role.getRole().getNameRole()));
      }
      return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

	@Override
	public String getUsername() {
		return businessUserName;
	}

	

}

