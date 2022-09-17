package com.app.hotel.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityFilter {

  private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

  @Autowired
  public SecurityFilter(JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
    this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf().
        disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class)
        .authorizeRequests()
        .anyRequest()
        .permitAll();

    return httpSecurity.build();
  }
}
