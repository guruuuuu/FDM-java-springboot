package com.fdmgroup.blog.models;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//JPA is a Java Persistence API (Application Programming Interface)
//JPA converts your model class to database tables
//Table name is optional
//@Entity means table in the database

@Entity
@Table(name = "Blog_User")
//@DiscriminatorValue("User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(updatable=false)
	private UUID userID = UUID.randomUUID();
	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 150, message= "Name has to be between 2 and 150 characters")
	private String name;
	@Email(regexp = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_.+(?:\\.[A-Za-z0-9]+)+)", message = "Email is not Valid")
	private	String email;
	@NotBlank(message = "Password is required!")
	@Size(min = 8, message = "Password has to be minimum 8 characters")
	private String password;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	//default constructor
	public User() {

	}

	public User(String name, String email, String password) {
		this.userID = getUserID();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public UUID getUserID() {
		return userID;
	}

//	public void setUserID(UUID userID) {
//		this.userID = userID;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;

	}

	@PrePersist
	private void createAt() {
		this.createdAt = LocalDate.now();
	}

	@PreUpdate
	private void updateAt() {
		this.updatedAt = LocalDate.now();
	}

}
