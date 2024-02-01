package com.carwash.carservice.service;

import java.util.List;
import java.util.Optional;

import com.carwash.carservice.entity.Car;
import com.carwash.carservice.model.CarDto;

public interface CarService {
	String updateCar(CarDto carDto);
	Optional<CarDto> getCarByCarId(int carId);
	List<CarDto> getAllCars();
	void deleteCar(int carId);
	boolean existsById(int carId);
	String addCar(CarDto carDto);
	List<CarDto> getCarsByCustomerId(int userId);

}