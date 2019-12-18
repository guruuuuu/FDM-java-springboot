package com.fdm.cargarage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdm.cargarage.models.Car;
import com.fdm.cargarage.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Car listCar(Car car) {
		return this.carRepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		return this.carRepository.findAll();
	}

	@Override
	public Car getCarByNumplate(String numplate) {
		return this.carRepository.findByNumplate(numplate);
	}

	@Override
	public List<Car> getCarsByNumplate(String numplate) {
		return this.carRepository.findAllByNumplate(numplate);
	}

	@Override
	public void deleteCar(String numplate) {
		Car foundCar = this.getCarByNumplate(numplate);
		this.carRepository.delete(foundCar);		
	}





}
