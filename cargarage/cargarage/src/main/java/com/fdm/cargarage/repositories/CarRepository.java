package com.fdm.cargarage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdm.cargarage.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	public Car findByNumplate(String numplate);
	public List<Car> findAllByNumplate(String numplate);
}
