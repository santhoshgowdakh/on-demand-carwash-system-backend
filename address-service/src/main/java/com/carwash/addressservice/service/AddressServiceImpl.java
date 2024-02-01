package com.carwash.addressservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.addressservice.entity.Address;
import com.carwash.addressservice.entity.AddressDto;
import com.carwash.addressservice.exception.AddressNotFoundException;
import com.carwash.addressservice.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private SequenseGeneratorService sequenseGeneratorService;

	@Override
	public int addAddress(AddressDto addressDto) {
		Address address = new Address();
		address.setAddressId(sequenseGeneratorService.getSequenseNumber(address.SEQUENCE_NAME));
		address.setCity(addressDto.getCity());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setStreet(addressDto.getStreet());
		address.setAddressName(addressDto.getAddressName());
		address.setUserId(addressDto.getUserId());
		addressRepository.save(address);

		return address.getAddressId();
	}

	@Override
	public Optional<Address> getAddressByAddressId(int addressId) {
		Optional<Address> address = null;
		if (addressRepository.existsById(addressId))
			address = addressRepository.findById(addressId);
		else
			throwNotFoundException();

		return address;
	}

	@Override
	public void updateAddress(Address address) {
		if (addressRepository.existsById(address.getAddressId()))
			addressRepository.save(address);
		else
			throwNotFoundException();
	}

	@Override
	public void deleteAddress(int AddressId) {
		if (addressRepository.existsById(AddressId))
			addressRepository.deleteById(AddressId);
		else
			throwNotFoundException();
	}
	
	@Override
	public List<Address> getAllAddress() {
		List<Address> allUser = addressRepository.findAll();
		if (allUser.isEmpty()) {
			throw new AddressNotFoundException("User list is empty....");
		}
		return allUser;
	}

	public void throwNotFoundException() {
		throw new AddressNotFoundException("Address does not exists...");
	}

}
