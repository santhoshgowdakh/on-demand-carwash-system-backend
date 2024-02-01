package com.carwash.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.userservice.entity.LoginResponse;
import com.carwash.userservice.entity.User;
import com.carwash.userservice.exception.InvalidEmailException;
import com.carwash.userservice.exception.InvalidMobileNumberException;
import com.carwash.userservice.exception.InvalidUserAgeException;
import com.carwash.userservice.exception.UserNameAlreadyExistException;
import com.carwash.userservice.exception.UserNotFoundException;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.model.UserDtoAdd;
import com.carwash.userservice.model.UserDtoUpdate;
import com.carwash.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	SequenseGeneratorService sequenseGeneratorService;

	@Override
	public String addUser(UserDtoAdd userDtoAdd) {

		return saveUserDetail(userDtoAdd, "saved");
	}

	@Override
	public String updateUser(UserDtoUpdate userDtoUpdate) {

		User existingUser = userRepository.findUserByUserId(userDtoUpdate.getUserId());
		//Address address = new Address();

		
		if (existingUser == null)
			throwNotFoundException(userDtoUpdate.getUserId());

		existingUser.setFirstName(userDtoUpdate.getFirstName());
		existingUser.setLastName(userDtoUpdate.getLastName());
		existingUser.setMobileNumber(userDtoUpdate.getMobileNumber());
		existingUser.setAge(userDtoUpdate.getAge());
		existingUser.setEmail(userDtoUpdate.getEmail());
		existingUser.setUserRole(userDtoUpdate.getUserRole());
		//address.setStreet(userDtoUpdate.getAddressDto().getStreet());
		//address.setCity(userDtoUpdate.getAddressDto().getCity());
		//address.setState(userDtoUpdate.getAddressDto().getState());
		//address.setPincode(userDtoUpdate.getAddressDto().getPincode());
		//address.setAddressId(userDtoUpdate.getAddressDto().getAddressId());
		//restTemplate.put("http://localhost:8090/address/updateAddress", address);
		//existingUser.setAddressId(userDtoUpdate.getAddressDto().getAddressId());
		userRepository.save(existingUser);
		return "User detail updated with carId :" + existingUser.getUserId();

	}

	@Override
	
	public UserDto getUserByUserId(int userId) {
		
		if (!userRepository.existsById(userId)) 
			throwNotFoundException(userId);
			User user = userRepository.findUserByUserId(userId);
			UserDto userDto = new UserDto();

			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setAge(user.getAge());
			userDto.setEmail(user.getEmail());
			userDto.setMobileNumber(user.getMobileNumber());
			userDto.setUserRole(user.getUserRole());
			userDto.setUserId(user.getUserId());
	
		return userDto;
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throwNotFoundException(userId);
		}
		userRepository.deleteById(userId);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> allUser = userRepository.findAll();
		if (allUser.isEmpty()) {
			throw new UserNotFoundException("Sorry user list is empty....");
		}
		List<UserDto> userDtos = new ArrayList<>();
		for (User user : allUser) {
			UserDto userDto = new UserDto();
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setAge(user.getAge());
			userDto.setEmail(user.getEmail());
			userDto.setMobileNumber(user.getMobileNumber());
			userDto.setUserRole(user.getUserRole());
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			//Address address = restTemplate.getForObject("http://localhost:8090/address/" + user.getAddressId(),Address.class);
			//AddressDto addressDto = new AddressDto();
			//addressDto.setAddressId(address.getAddressId());
			//addressDto.setCity(address.getCity());
			//addressDto.setPincode(address.getPincode());
			//////addressDto.setState(address.getState());
			//addressDto.setStreet(address.getStreet());
			//userDto.setAddressDto(addressDto);
			userDtos.add(userDto);
		}
		return userDtos;
	}

	@Override
	public LoginResponse getUserByUserName(String userName) {
			User user = userRepository.findUserByUserName(userName);
		if (user == null)
			throw new UserNotFoundException("User not found with " + userName + " name");
			LoginResponse loginResponse=new LoginResponse();
			loginResponse.setUserId(user.getUserId());
			loginResponse.setUserName(user.getUserName());
			loginResponse.setPassword(user.getPassword());
			loginResponse.setUserRole(user.getUserRole());
			return loginResponse;
		}
		
	

	@Override
	public boolean existsById(int userId) {
		return userRepository.existsById(userId);
	}

	public void throwNotFoundException(int userId) {
		throw new UserNotFoundException("User not found with this Id :" + userId);
	}

	private String saveUserDetail(UserDtoAdd userDtoAdd, String action) {
		User user = null;
		if (action.equals("saved")) {
			user = new User();
			user.setUserId(sequenseGeneratorService.getSequenseNumber(user.SEQUENCE_NAME));
		} else {
			user = userRepository.findUserByUserId(userDtoAdd.getUserId());
		}
		//Address address = new Address();
		
		user.setFirstName(userDtoAdd.getFirstName());
		user.setLastName(userDtoAdd.getLastName());

		User existingUser = userRepository.findUserByUserName(userDtoAdd.getUserName());
		if (existingUser != null)
			throw new UserNameAlreadyExistException("Username already exist");
		user.setUserName(userDtoAdd.getUserName());

		user.setPassword(userDtoAdd.getPassword());
		user.setUserRole(userDtoAdd.getUserRole());

		if (userDtoAdd.getAge() <= 0)
			throw new InvalidUserAgeException("Age should be a positive number");
		user.setAge(userDtoAdd.getAge());
		
		user.setEmail(userDtoAdd.getEmail());

		if (userDtoAdd.getMobileNumber().length() != 10)
			throw new InvalidMobileNumberException("Invalid mobile number...");

		user.setMobileNumber(userDtoAdd.getMobileNumber());
		userRepository.save(user);
		return "User detail " + action + " with userId :" + user.getUserId();

	}

	@Override
	public List<UserDto> getAllUserByRole(String role) {
		List<UserDto> userListByRole = getAllUser().stream().filter(u -> u.getUserRole().equals(role))
				.collect(Collectors.toList());
		if (userListByRole.isEmpty())
			throw new UserNotFoundException("Sorry user not found with " + role + " role....");
		return userListByRole;
	}

}
