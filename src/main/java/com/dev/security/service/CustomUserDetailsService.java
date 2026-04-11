package com.dev.security.service;

import com.dev.security.entity.User;
import com.dev.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		return org.springframework.security.core.userdetails.User
			.builder()
			.username(user.getEmail())
			.password(user.getPassword())
			.roles(user.getRole()
				.name()
				.replace("ROLE_", ""))
			.build();
	}

}
