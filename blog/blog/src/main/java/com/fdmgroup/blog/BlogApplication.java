package com.fdmgroup.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.fdmgroup.blog.models.User;
import com.fdmgroup.blog.repositories.UserRepository;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private PersonRepository personRepository;
	
	//@Autowired
	//private TutorRepository tutorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("James Bond", "jd@msn.com", "111-222-333" );
		User user2 = new User("Jhon Doe", "jd@gmail.com", "111-222-334");
		//Person person = new Person("TomJones", "tj@msn.com ", "abc123");
		//Tutor  tutor = new Tutor("Waleed Malik", "wm@msn.com ", "abcdef123456", 100000);
				this.userRepository.save(user);
				this.userRepository.save(user2);
				//this.personRepository.save(person);
				//this.tutorRepository.save(tutor);
		
	}
}
