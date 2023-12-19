package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	public String addUser(User user) {
		User user1=userRepo.save(user);
		if(user1 !=null) {
			return "user Added Successfully";
		}
		return "Something went wrong";
	}
	
	public User loginUser(User user) {
		System.out.println(user.getPassword());
	User user1 =userRepo.findByEmail(user.getEmail());
	System.out.println(user1.getPassword());
	
	if(user.getPassword().equals (user1.getPassword())) {
		
		return user1;
	}
		return null;
	}
   public User findByEmail(String email) {
	   return userRepo.findByEmail(email);
   }
   public String updateUser(User user) {
		User user1=userRepo.findByEmail(user.getEmail());
		if(user1==null) return "User with this email not found";
		user.setId(user1.getId());
		if(userRepo.save(user)!=null) {
			return "User Details updated Successfully";
		}
		return "Something went wrong";
	}


   public String deleteUser(String email) {
		User user=userRepo.findByEmail(email);
		if(user != null) {
			userRepo.deleteById(user.getId());
			return "User Details deleted successfully";
		}
		return "User not found";
   }

	
	public List<User> getAllUser() {
		List<User> users=userRepo.findAll();
		return users;
		
	}
}
