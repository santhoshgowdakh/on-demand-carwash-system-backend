package com.carwash.addressservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.carwash.addressservice.entity.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, Integer>{

}


