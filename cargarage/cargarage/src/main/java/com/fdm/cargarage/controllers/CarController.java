package com.fdm.cargarage.controllers;

import java.util.List;


//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdm.cargarage.models.Car;
import com.fdm.cargarage.services.CarService;


@Controller
public class CarController {

	private CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/list")
	public String list() {
		return "list";
	}

	@PostMapping("/list")
	public String list(@RequestParam String make, @RequestParam String model, @RequestParam String colour,
			@RequestParam int mileage, @RequestParam double price, @RequestParam String numplate, ModelMap map) {
		Car newCar = new Car(make, model, colour, mileage, price, numplate);
		this.carService.listCar(newCar);
		List<Car> list = this.carService.getAllCars();
		map.addAttribute("cars", list);
		return "all-cars";
	}

	@GetMapping("/all-cars")
	public String getAllCars(ModelMap map) {
		List<Car> list = this.carService.getAllCars();
		map.addAttribute("books", list);
		return "all-cars";
	}

	@GetMapping("/delete")
	public String deleteCar(@RequestParam String numplate, ModelMap map) {
		this.carService.deleteCar(numplate);
		List<Car> result = this.carService.getAllCars();
		map.addAttribute("cars", result);
		return "all-cars";
	}
	@GetMapping("/edit")
	public String updateCar(@RequestParam String numplate, ModelMap map) {
		Car foundCar = this.carService.getCarByNumplate(numplate);
		map.addAttribute("car", foundCar);
		return "edit-car";
	}
	@PostMapping("/edit")
	public String updateCar(@RequestParam Long id, @RequestParam String make, @RequestParam String model, @RequestParam String colour, @RequestParam int mileage, @RequestParam double price, @RequestParam String numplate, ModelMap map) {
		Car car  = new Car(make, model, colour, mileage, price, numplate);
		car.setId(id);
		this.carService.listCar(car);
		List<Car> cars = this.carService.getAllCars();
		map.addAttribute("cars", cars);
		return "all-cars";
	}
	
	@GetMapping("/search")
	public String searchCar(@RequestParam String numplate, ModelMap map) {
		List<Car> cars  = this.carService.getCarsByNumplate(numplate);
		map.addAttribute("cars", cars);
		return "search";
	}
}