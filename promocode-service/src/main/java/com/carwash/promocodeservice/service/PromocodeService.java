package com.carwash.promocodeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carwash.promocodeservice.entity.Promocode;

public interface PromocodeService {

	void addPromocode(Promocode promocode);
	void updatePromocode(Promocode promocode);
	List<Promocode> getAllPromocodes();
	void deletePromocode(String promocode);
	Promocode getByPromocode(String promocode);
	boolean existsById(String promocode);
}

