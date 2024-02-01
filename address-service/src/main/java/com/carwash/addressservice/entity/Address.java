package com.carwash.addressservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {

	@Transient
	public static final String SEQUENCE_NAME = "address_sequense";
	@Id
	private int addressId;
	private String addressName;
	private String street;
	private String city;
	private int pincode;
	private String state;
	private int UserId;

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public Address() {
	}

	public Address(int addressId, String street, String city, int pincode, String state) {
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
