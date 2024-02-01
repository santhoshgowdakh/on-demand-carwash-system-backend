package com.carwash.userservice.service;

import java.util.List;
import java.util.Optional;

import com.carwash.userservice.entity.LoginResponse;
import com.carwash.userservice.entity.User;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.model.UserDtoAdd;
import com.carwash.userservice.model.UserDtoUpdate;

public interface UserService {

	public LoginResponse getUserByUserName(String userName);
	public void deleteUser(int userId);
	public List<UserDto> getAllUserByRole(String role);
	boolean existsById(int userId);
	public List<UserDto> getAllUser();
	public String addUser(UserDtoAdd userDtoAdd);
	public String updateUser(UserDtoUpdate userDtoUpdate);
	UserDto getUserByUserId(int userId);

}
