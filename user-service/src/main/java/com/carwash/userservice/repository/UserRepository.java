package com.carwash.userservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.userservice.entity.User;



@Repository
public interface UserRepository extends MongoRepository<User, Integer>{


	
	@Query("{userName:?0}")
	public User findUserByUserName(String userName);
	@Query("{userId:?0}")
	public User findUserByUserId(int userId);
	@Query("{userRole:?0}")
	public List<User> findByRole(String role);
	
	}
