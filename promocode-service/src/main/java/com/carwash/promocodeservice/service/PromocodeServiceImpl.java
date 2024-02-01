package com.carwash.promocodeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.promocodeservice.entity.Promocode;
import com.carwash.promocodeservice.exception.PromocodeAlreadyExistsException;
import com.carwash.promocodeservice.exception.PromocodeNotFoundException;
import com.carwash.promocodeservice.repository.PromocodeRepository;

@Service
public class PromocodeServiceImpl implements PromocodeService {

	@Autowired
	PromocodeRepository promocodeRepository;
	
	@Override
	public void addPromocode(Promocode promocode) {
		if(promocodeRepository.getByPromocode(promocode.getPromocode())!=null)
			throw new PromocodeAlreadyExistsException("promocode already exists");
		promocodeRepository.save(promocode);
	}

	@Override
	public void updatePromocode(Promocode promocode) {
		if(!existsById(promocode.getPromocode()))
			throwNotFoundException();
		promocodeRepository.save(promocode);
	}

	
	@Override
	public Promocode getByPromocode(String promocode) {
		Promocode promocodeDetails=promocodeRepository.getByPromocode(promocode);
		if(promocode==null)
			throwNotFoundException();
		return promocodeDetails;
	}

	@Override
	public List<Promocode> getAllPromocodes() {
		List<Promocode> promocodes= promocodeRepository.findAll();
		if(promocodes.size()==0)
			throwNotFoundException();
		return promocodes;
	}

	@Override
	public void deletePromocode(String promocode) {
		if(!existsById(promocode))
			throwNotFoundException();
		promocodeRepository.deleteById(promocode);
		
	}
	
	public void throwNotFoundException() {
		throw new PromocodeNotFoundException("Promocode doesnot exists...");
	}
	
	@Override
	public boolean existsById(String promocode) {
		return promocodeRepository.getByPromocode(promocode)!=null;
	}
}
