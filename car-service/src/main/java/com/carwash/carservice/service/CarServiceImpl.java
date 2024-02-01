package com.carwash.carservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.carservice.entity.Address;
import com.carwash.carservice.entity.Car;
import com.carwash.carservice.exception.CarNotFoundException;
import com.carwash.carservice.model.CarDto;
import com.carwash.carservice.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	SequenseGeneratorService sequenseGeneratorService;

	@Override
	public String addCar(CarDto carDto) {
		return saveCarDetail(carDto, "saved");
	}

	public List<CarDto> getAllCars() {

		List<Car> allCarList = carRepository.findAll();
		if (allCarList.isEmpty()) {
			throw new CarNotFoundException("Sorry no Car details available...!");
		}
		List<CarDto>carDtos=new ArrayList<>();
		for(Car car:allCarList) {
			CarDto carDto=new CarDto();
			carDto.setCarBrand(car.getCarBrand());
			carDto.setCarColor(car.getCarColor());
			carDto.setCarImage(car.getCarImage());
//			carDto.setCarLocation(car.getCarLocation());
			carDto.setCarModel(car.getCarModel());
			carDto.setCarRegistrationNumber(car.getCarRegistrationNumber());
			carDto.setCarId(car.getCarId());
			carDto.setUserId(car.getUserId());
			//Address address = restTemplate.getForObject("http://localhost:8090/address/" + car.getAddressId(),
						//Address.class);
				//AddressDto addressDto = new AddressDto();
				//addressDto.setAddressId(address.getAddressId());
				//addressDto.setCity(address.getCity());
				//addressDto.setPincode(address.getPincode());
				//addressDto.setState(address.getState());
				//addressDto.setStreet(address.getStreet());
				//carDto.setAddressDto(addressDto);
			
				carDtos.add(carDto);
		}
		return carDtos;
	}

	@Override
	public Optional<CarDto> getCarByCarId(int carId) {
		Optional<Car> car = null;
		CarDto carDto = new CarDto();
		if (carRepository.existsById(carId)) {
			car = carRepository.findById(carId);
			carDto.setCarBrand(car.get().getCarBrand());
			carDto.setCarColor(car.get().getCarColor());
			carDto.setCarId(car.get().getCarId());
			carDto.setCarImage(car.get().getCarImage());
//			carDto.setCarLocation(car.get().getCarLocation());
			carDto.setCarModel(car.get().getCarModel());
			carDto.setCarRegistrationNumber(car.get().getCarRegistrationNumber());
			//Address address = restTemplate.getForObject("http://localhost:8090/address/" + car.get().getAddressId(),
					//Address.class);
			//AddressDto addressDto = new AddressDto();
			//addressDto.setAddressId(address.getAddressId());
			//addressDto.setCity(address.getCity());
			//addressDto.setPincode(address.getPincode());
			//addressDto.setState(address.getState());
			//addressDto.setStreet(address.getStreet());
			//carDto.setAddressDto(addressDto);
			
		} else
			throwNotFoundException();
		return Optional.of(carDto);
	}
	

	@Override
	public String updateCar(CarDto carDto) {

		Optional<Car> existingCar = null;
		//AddressDto addressDto=new AddressDto();
		if (carRepository.existsById(carDto.getCarId())) {
	   existingCar=carRepository.findById(carDto.getCarId());

		existingCar.get().setCarBrand(carDto.getCarBrand());
		existingCar.get().setCarColor(carDto.getCarColor());
		existingCar.get().setCarImage(carDto.getCarImage());
		existingCar.get().setCarModel(carDto.getCarModel());
		existingCar.get().setCarRegistrationNumber(carDto.getCarRegistrationNumber());	
		
		//carRepository.save(existingCar);
		return "Car detail updated with carId :" + existingCar.get().getCarId() + " and addressId :"
				;
		}



		return null;
	}


     @Override
	public void deleteCar(int carId) {
		if (carRepository.existsById(carId))
			carRepository.deleteById(carId);
		else
			throwNotFoundException();
	}

	public void throwNotFoundException() {
		throw new CarNotFoundException("Car does not exists...");
	}

	private String saveCarDetail(CarDto carDto, String action) {
		Car car = new Car();
		Address address = new Address();
		car.setCarBrand(carDto.getCarBrand());
		car.setCarColor(carDto.getCarColor());
		car.setCarId(sequenseGeneratorService.getSequenseNumber(car.SEQUENCE_NAME));
		car.setCarImage(carDto.getCarImage());
//		car.setCarLocation(carDto.getCarLocation());
		car.setCarRegistrationNumber(carDto.getCarRegistrationNumber());
		car.setUserId(carDto.getUserId());
		//address.setCity(carDto.getAddressDto().getCity());
		//address.setPincode(carDto.getAddressDto().getPincode());
		//address.setState(carDto.getAddressDto().getState());
		//address.setStreet(carDto.getAddressDto().getStreet());

		//int addressId = restTemplate.postForObject("http://localhost:8090/address/addAddress", address, Integer.class);
		//car.setAddressId(addressId);

//		int addressId = restTemplate.postForObject("http://localhost:8090/address/addAddress", address, Integer.class);
//		car.setAddressId(addressId);

		carRepository.save(car);
		return "Car detail " + action + " with carId :" + car.getCarId();

	}
	
	@Override
	public boolean existsById(int carId) {
		return carRepository.existsById(carId);
	}

	@Override
	public List<CarDto> getCarsByCustomerId(int userId) {
		List<Car> allCarList = carRepository.getCarsByCustomerId(userId);
		if (allCarList.isEmpty()) {
			throw new CarNotFoundException("Sorry no Car details available...!");
		}
		List<CarDto>carDtos=new ArrayList<CarDto>();
		for(Car car:allCarList) {
			CarDto carDto=new CarDto();
			carDto.setCarBrand(car.getCarBrand());
			carDto.setCarColor(car.getCarColor());
			carDto.setCarImage(car.getCarImage());
//			carDto.setCarLocation(car.getCarLocation());
			carDto.setCarModel(car.getCarModel());
			carDto.setCarRegistrationNumber(car.getCarRegistrationNumber());
			carDto.setCarId(car.getCarId());
			carDto.setUserId(car.getUserId());
			carDto.setCarType(car.getCarType());
			
				carDtos.add(carDto);
		}
		return carDtos;
	}

}
