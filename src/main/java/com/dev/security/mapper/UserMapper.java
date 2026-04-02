package com.dev.security.mapper;

import com.dev.security.entity.User;
import com.dev.security.dto.request.UserRequestDTO;
import com.dev.security.dto.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public UserResponseDTO toDTO(User user) {
		return new UserResponseDTO(
			user.getId(),
			user.getName(),
			user.getEmail(),
			user.getRole());
	}

	public User toEntity(UserRequestDTO userRequestDTO) {
		return User
			.builder()
			.id(userRequestDTO.id())
			.name(userRequestDTO.name())
			.email(userRequestDTO.email())
			.password(userRequestDTO.password())
			.build();
	}
}
