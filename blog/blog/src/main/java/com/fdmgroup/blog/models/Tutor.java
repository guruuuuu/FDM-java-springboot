package com.fdmgroup.blog.models;

import java.time.LocalDate;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "Tutor")
@DiscriminatorValue("Tutor")
public class Tutor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// private UUID tutorId;
	private Long salary;

	private LocalDate createdAt;
	private LocalDate updatedAt;

	public Tutor() {

	}

	public Tutor(String name, String email, String password, long salary) {
		super(name, email, password);
		// this.tutorId = UUID.randomUUID();
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
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
