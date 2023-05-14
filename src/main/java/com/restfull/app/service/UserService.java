package com.restfull.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.restfull.app.model.dto.UserDto;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto user);
}
