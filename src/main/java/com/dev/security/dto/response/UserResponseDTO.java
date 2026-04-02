package com.dev.security.dto.response;

import com.dev.security.entity.enums.Role;

public record UserResponseDTO(
	Long id,
	String name,
	String email,
	Role role) {
}
