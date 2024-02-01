package com.carwash.planservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.planservice.entity.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan, Integer>{

	@Query("{planId:?0}")
	Plan getPlanByPlanId(int planId);
	
	@Query("{carType:?0}")
	List<Plan> findAllPlansByCarType(String carType);
}
