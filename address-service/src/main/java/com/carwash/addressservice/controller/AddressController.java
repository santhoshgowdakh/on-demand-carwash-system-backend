package com.carwash.addressservice.controller;

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

import com.carwash.addressservice.entity.Address;
import com.carwash.addressservice.entity.AddressDto;
import com.carwash.addressservice.service.AddressService;

@CrossOrigin(origins= "*" ,maxAge = 3600)
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/addAddress")
	public ResponseEntity<Integer> addAddress(@Valid @RequestBody AddressDto addressDto) {
		int addressId = addressService.addAddress(addressDto);
		return new ResponseEntity<Integer>( addressId, HttpStatus.OK);
	}
	

	@PutMapping("/updateAddress")
	public void updateAddress(@Valid @RequestBody Address address) {
		addressService.updateAddress(address);
//		return new ResponseEntity<String>("address updated", HttpStatus.OK);
	}
	
	@GetMapping("/{addressId}")
	public ResponseEntity<Optional<Address>> getAddressByAddressId(@PathVariable int addressId) {
		Optional<Address> address = addressService.getAddressByAddressId(addressId);
		return new ResponseEntity<Optional<Address>>(address, HttpStatus.OK);
	}

	@DeleteMapping("/{addressId}")
	public ResponseEntity<String> deleteAddress(@PathVariable int addressId) {
		addressService.deleteAddress(addressId);
		return new ResponseEntity<String>("Address deleted", HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public List<Address> fetchAllAddresses() {
		List<Address> allAddress = addressService.getAllAddress();
		return allAddress;
	}
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<Address>> getAddressByUserId(@PathVariable int userId) {
		List<Address> userAddress = addressService.getAllAddress();
		return new ResponseEntity<List<Address>>(userAddress, HttpStatus.OK);
	}

}
