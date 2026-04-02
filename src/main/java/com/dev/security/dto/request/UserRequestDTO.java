package com.dev.security.dto.request;

public record UserRequestDTO(
	Long id,
	String name,
	String email,
	String password) {
}
