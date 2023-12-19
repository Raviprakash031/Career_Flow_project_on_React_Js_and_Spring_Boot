package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User user1=userRepository.save(user);
		if(user1 !=null) {
			return user1;
		}
		
		return null;
	}
	
	public User loginUser(User user) {
	User user1 =userRepository.findByEmail(user.getEmail());
	
	
	if(passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
		return user1;
	}
		return null;
	}
   public User findByEmail(String email) {
	   return userRepository.findByEmail(email);
   }
	
	
}
