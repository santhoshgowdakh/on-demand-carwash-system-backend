package com.carwash.promocodeservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.promocodeservice.entity.Promocode;

@Repository
public interface PromocodeRepository extends MongoRepository<Promocode, String>{

	@Query("{promocode:?0}")
	Promocode getByPromocode(String promocode);
	
}
