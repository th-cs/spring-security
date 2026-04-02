package com.dev.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		httpSecurity
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
			.requestMatchers("/api/users").permitAll()
			.requestMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());

		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
