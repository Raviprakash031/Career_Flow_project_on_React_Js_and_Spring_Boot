package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserAuthenticationProvider;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		User user1=userService.addUser(user);
		//give him a  jwt token
		user1.setToken(userAuthenticationProvider.createToken(user1.getEmail()));
		System.out.println(" jwt token whlie register "+user1.getToken());
		return ResponseEntity.ok(user1);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user){
		System.out.println(" This method was hit ");
		User user1=userService.loginUser(user);
		//give him a  jwt token
		user1.setToken(userAuthenticationProvider.createToken(user1.getEmail()));
		System.out.println(" jwt token whlie login "+user1.getToken());
		return ResponseEntity.ok(user1);
	}
	
}
