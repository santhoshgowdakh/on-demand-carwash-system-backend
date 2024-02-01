package com.carwash.addressservice.service;

import java.util.List;
import java.util.Optional;

import com.carwash.addressservice.entity.Address;
import com.carwash.addressservice.entity.AddressDto;

public interface AddressService {
	int addAddress(AddressDto addressDto);
	void updateAddress(Address address);
	void deleteAddress(int addressId);
	Optional<Address> getAddressByAddressId(int addressId);
	List<Address> getAllAddress();

}
