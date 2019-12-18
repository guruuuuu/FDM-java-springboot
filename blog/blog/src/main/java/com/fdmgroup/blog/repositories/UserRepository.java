package com.fdmgroup.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.blog.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email); 
	public User findByEmailAndPassword(String email, String password);
}
