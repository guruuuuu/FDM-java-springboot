package com.fdm.cargarage.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "Car_Garage")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String make;
	private String model;
	private String colour;
	private int mileage;
	private double price;
	private String numplate;

	private LocalDate listedAt;
	private LocalDate updatedAt;

	public Car() {

	}

	public Car(String make, String model, String colour, int mileage, double price, String numplate) {
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.mileage = mileage;
		this.price = price;
		this.numplate = numplate;
	}

	public String getNumplate() {
		return numplate;
	}

	public void setNumplate(String numplate) {
		this.numplate = numplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getListedAt() {
		return listedAt;
	}

	public void setListedAt(LocalDate listedAt) {
		this.listedAt = listedAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	public void listedAt() {
		this.listedAt = LocalDate.now();
	}
	
	@PreUpdate
	public void updatedAt() {
		this.updatedAt = LocalDate.now();
	}
}
