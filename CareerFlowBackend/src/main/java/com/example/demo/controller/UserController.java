package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		
		String result =userService.addUser(user);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user){
		System.out.println(" This method was hit ");
		User user1=userService.loginUser(user);
		return ResponseEntity.ok(user1);
	}
	
	@PutMapping("/updateUser")
    public ResponseEntity<String> updateUser( @RequestBody User updatedUser) {
        String result = userService.updateUser(updatedUser);
        return ResponseEntity.ok(result);
        
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        String result=userService.deleteUser(email);
        return ResponseEntity.ok(result);
    }
    
    
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
    	List<User> users=userService.getAllUser();
    	return ResponseEntity.ok(users);
    	
    }
	
}
