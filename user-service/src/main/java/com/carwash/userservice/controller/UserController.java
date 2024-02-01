package com.carwash.userservice.controller;

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

import com.carwash.userservice.entity.LoginResponse;
import com.carwash.userservice.entity.User;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.model.UserDtoAdd;
import com.carwash.userservice.model.UserDtoUpdate;
import com.carwash.userservice.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save")
	@CrossOrigin
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDtoAdd userDtoAdd) {
		String msg = userService.addUser(userDtoAdd);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDtoUpdate userDtoUpdate) {
		String msg=userService.updateUser(userDtoUpdate);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list")
	public List<UserDto> fetchAllUser() {
		List<UserDto> allUser = userService.getAllUser();
		return allUser;
	}

	/*
	 * @GetMapping("/id/{userId}")
	 *  public ResponseEntity<Object>fetchById(@PathVariable("userId") int userId) {
	 * ResponseEntity<Object> reponseEntity = null; User user =
	 * userService.getUserByUserId(userId); reponseEntity = new
	 * ResponseEntity<>(user, HttpStatus.OK); return reponseEntity; }
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/id/{userId}")
	public ResponseEntity<UserDto> getUserByUserId(@PathVariable int userId) {
		UserDto user = userService.getUserByUserId(userId);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/username/{userName}")
	public LoginResponse loadByUserName(@PathVariable("userName") String userName) {

		ResponseEntity<LoginResponse> reponseEntity = null;
		LoginResponse loginResponse = userService.getUserByUserName(userName);
		// reponseEntity = new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		return loginResponse;
	}

	

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId) {

		userService.deleteUser(userId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/exists/{userId}")
	public ResponseEntity<Boolean> existsById(@PathVariable int userId){
		boolean exists=userService.existsById(userId);
		return new ResponseEntity<Boolean>(exists,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getbyrole")
	public List<UserDto> fetchAllUserByRole(String role) {
		List<UserDto> allUser = userService.getAllUserByRole(role);
		return allUser;
	}

}
