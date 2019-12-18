package com.fdm.cargarage.services;

import java.util.List;

import com.fdm.cargarage.models.Car;

public interface CarService {

	public Car listCar(Car car);

	public List<Car> getAllCars();

	public Car getCarByNumplate(String numplate);

	public List<Car> getCarsByNumplate(String numplate);
	
	public void deleteCar(String numplate);
}
