package com.dev.security.controller;

import com.dev.security.service.UserService;
import com.dev.security.dto.request.UserRequestDTO;
import com.dev.security.dto.response.UserResponseDTO;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> listAllUsers() {
		return ResponseEntity.ok(userService.listAllUsers());
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(
	@RequestBody UserRequestDTO userRequestDTO) {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(userService.createUser(userRequestDTO));
	}

}
