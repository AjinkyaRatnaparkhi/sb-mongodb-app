package com.app.mongodb.sb_mongodb_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	
	@Bean
	SecurityFilterChain securityFilertChain(HttpSecurity httpSecurity) throws Exception {
		SecurityFilterChain securityFilterChain = 
				httpSecurity
				.csrf(t ->{ t.disable();})
				.authorizeHttpRequests(  auth -> {
					auth.requestMatchers("/actuator/**").permitAll()
					.anyRequest().authenticated();
					
					})
				.httpBasic(t ->{ } ).
				
				build();
		return securityFilterChain;
		
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder()
				.username("admin")
				.password(encoder().encode("password"))
				.roles("ADMIN")
				.build();
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(userDetails);
		return inMemoryUserDetailsManager;
		
	}
	
	
}
