package com.dev.security.service;

import com.dev.security.repository.UserRepository;
import com.dev.security.entity.User;
import com.dev.security.mapper.UserMapper;
import com.dev.security.dto.request.UserRequestDTO;
import com.dev.security.dto.response.UserResponseDTO;
import com.dev.security.entity.enums.Role;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserMapper userMapper,
	PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public List<UserResponseDTO> listAllUsers() {
		return userRepository.findAll()
			.stream()
			.map(user -> userMapper.toDTO(user))
			.collect(Collectors.toList());
	}

	public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
		User user = userMapper.toEntity(userRequestDTO);

		user.setPassword(passwordEncoder.encode(userRequestDTO.password()));
		user.setRole(Role.ROLE_USER);

		userRepository.save(user);
		return userMapper.toDTO(user);
	}

}
