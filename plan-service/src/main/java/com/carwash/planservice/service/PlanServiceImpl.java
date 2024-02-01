package com.carwash.planservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.planservice.entity.Plan;
import com.carwash.planservice.exception.PlanNotFoundException;
import com.carwash.planservice.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;

	@Override
	public int addPlan(Plan plan) {
		planRepository.save(plan);
		return plan.getPlanId();
	}

	@Override
	public void updatePlan(Plan plan) {
		if(planRepository.existsById(plan.getPlanId()))
			planRepository.save(plan);
		else
			throwPlanNotFoundException();
	}

	@Override
	public Plan getPlanByPlanId(int planId) {
		Plan plan=null;
		if(planRepository.existsById(planId))
			plan=planRepository.getPlanByPlanId(planId);
		else
			throwPlanNotFoundException();
		return plan;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}

	@Override
	public void deletePlan(int planId) {
		if(planRepository.existsById(planId))
			planRepository.deleteById(planId);
		else
			throwPlanNotFoundException();
	}
	@Override
	public boolean existsById(int planId) {
		return planRepository.existsById(planId);
		
	}
	@Override
	public List<Plan> getAllPlansByCarType(String carType) {
		return planRepository.findAllPlansByCarType(carType);
	}
	public void throwPlanNotFoundException() {
		throw new PlanNotFoundException("Plan doesnot exists...");
	}

}
