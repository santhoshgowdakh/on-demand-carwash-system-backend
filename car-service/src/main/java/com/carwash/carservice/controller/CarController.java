package com.carwash.carservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.carservice.entity.Car;
import com.carwash.carservice.model.CarDto;
import com.carwash.carservice.service.CarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<String> addCar(@Valid @RequestBody CarDto carDto) {
		String msg = carService.addCar(carDto);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<String> updateCar(@Valid @RequestBody CarDto car) {
		String msg=carService.updateCar(car);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/id/{carId}")
	public ResponseEntity<Optional<CarDto>> getCarByCarId(@PathVariable int carId) {
		Optional<CarDto> car = carService.getCarByCarId(carId);
		return new ResponseEntity<Optional<CarDto>>(car, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list")
	public ResponseEntity<List<CarDto>> getAllCars() {
		List<CarDto> carList = carService.getAllCars();
		return new ResponseEntity<List<CarDto>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<CarDto>> getCarsByCustomerId(@PathVariable int customerId) {
		List<CarDto> carList = carService.getCarsByCustomerId(customerId);
		return new ResponseEntity<List<CarDto>>(carList, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{carId}")
	public ResponseEntity<String> deleteCar(@PathVariable int carId) {
		carService.deleteCar(carId);
		return new ResponseEntity<String>("Car deleted", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/exists/{carId}")
	public ResponseEntity<Boolean> existsById(@PathVariable int carId){
		boolean exists=carService.existsById(carId);
		return new ResponseEntity<Boolean>(exists,HttpStatus.OK);
	}
}
