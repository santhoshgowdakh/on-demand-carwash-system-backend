package com.carwash.carservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.carservice.entity.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, Integer>{

	@Query("{userId:?0}")
	List<Car> getCarsByCustomerId(int userId);
	@Query("{carId:?0}")
	Car getCarById(int carId);

	
}
