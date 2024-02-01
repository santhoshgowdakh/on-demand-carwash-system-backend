package com.carwash.carservice.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class CarDto {

	private int carId;
	private int userId;
	private String carImage;
	private String carRegistrationNumber;
	private String carColor;
	private String carBrand;
	private String carModel;

	private String carType;
	//private AddressDto addressDto;
	
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}




}
