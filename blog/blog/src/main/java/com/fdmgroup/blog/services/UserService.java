package com.fdmgroup.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.blog.models.User;
import com.fdmgroup.blog.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User newUser) {
		return this.userRepository.save(newUser);
	}

	//userRepository asks to get all the users in the database. 
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	//user repository ask the table if it has the email address exist in the table
	//table return the user object
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public void deleteUser(String email) {
		User user = this.findByEmail(email);
		this.userRepository.delete(user);
	}
}
