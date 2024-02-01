package com.carwash.planservice.service;

import java.util.List;
import com.carwash.planservice.entity.Plan;

public interface PlanService {

	int addPlan(Plan plan);
	void updatePlan(Plan plan);
	Plan getPlanByPlanId(int planId);
	List<Plan> getAllPlans();
	void deletePlan(int planId);
	boolean existsById(int planId);
	List<Plan> getAllPlansByCarType(String carType);
}
