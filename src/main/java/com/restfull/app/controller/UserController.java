package com.restfull.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.app.model.dto.UserDto;
import com.restfull.app.model.request.UserDetailsRequestModel;
import com.restfull.app.model.response.UserDetailsResponseModel;
import com.restfull.app.service.UserService;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user called!";
	}
	
	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		UserDetailsResponseModel returnValue = new UserDetailsResponseModel();
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user called!";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user called!";
	}

}