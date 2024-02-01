package com.carwash.apigatewaysecurity.models;

//import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;


public class User {

	private int userId;
//	@NotNull
	private String userName;
//	@NotNull
	private String firstName;
//	@NotNull
	private String lastName;
//	@NotNull
	private String mobileNumber;
//	@NotNull
	private int age;
//	@NotNull
	private String email;
//	@NotNull
	private String password;
//	@NotNull
	private String userRole;
//	@NotNull
	private int addressId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", age=" + age + ", email=" + email + ", userRole=" + userRole + ", addressId="
				+ addressId + "]";
	}

}
