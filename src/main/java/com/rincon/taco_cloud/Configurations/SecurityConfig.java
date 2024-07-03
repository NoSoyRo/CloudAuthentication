package com.rincon.taco_cloud.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rincon.taco_cloud.Controllers.CustomAuthenticationSuccessHandler;
import com.rincon.taco_cloud.Models.User;
import com.rincon.taco_cloud.Repositories.UserRepository;

@Configuration
public class SecurityConfig {
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepo) {
    return username -> {
      User user = userRepo.findByBusinessUserName(username);
      if (user != null) {
        return user;
      }
      throw new UsernameNotFoundException(
                      "User '" + username + "' not found");
    };
  }
  
  @Bean
  public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
      return new CustomAuthenticationSuccessHandler();
  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  http
      .authorizeRequests(authorize -> 
          authorize
              .antMatchers("/hello").hasRole("USER")
              .anyRequest().permitAll()
      )
      .formLogin(form -> form
          .loginPage("/login")
          .successHandler(myAuthenticationSuccessHandler())
      )
      .logout(logout -> logout
          .logoutSuccessUrl("/")
      )
      // Make H2-Console non-secured; for debug purposes
      .csrf(csrf -> csrf
              .ignoringRequestMatchers(
                  new AntPathRequestMatcher("/h2-console/**")
              )
          )
      // Allow pages to be loaded in frames from the same origin; needed for H2-Console
      .headers(headers -> headers
          .frameOptions(frameOptions -> frameOptions.sameOrigin())
      );
  return http.build();
  }
  
}

