package com.carwash.planservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.carwash.planservice.entity.Plan;
import com.carwash.planservice.service.PlanService;

@CrossOrigin(origins= "*" ,maxAge = 3600)
@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	PlanService planService;
	
	@PostMapping
	public void addPlan(@RequestBody Plan plan){
		int planId=planService.addPlan(plan);
//		return new ResponseEntity<String>("Plan added ID: "+planId,HttpStatus.OK);
	}
	
	@PutMapping
	public void updatePlan(@RequestBody Plan plan){
		planService.updatePlan(plan);
//		return new ResponseEntity<String>("Plan updated",HttpStatus.OK);
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<Plan> getPlanByPlanId(@PathVariable int planId){
		Plan plan=planService.getPlanByPlanId(planId);
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Plan>> getAllPlans(){
		List<Plan> plans=planService.getAllPlans();
		return new ResponseEntity<List<Plan>>(plans,HttpStatus.OK);
	}
	@DeleteMapping("/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable int planId){
		planService.deletePlan(planId);
		return new ResponseEntity<String>("Plan deleted",HttpStatus.OK);
	}
	@GetMapping("/exists/{planId}")
	public ResponseEntity<Boolean> existsById(@PathVariable int planId){
		boolean exists=planService.existsById(planId);
		return new ResponseEntity<Boolean>(exists,HttpStatus.OK);
	}
	@CrossOrigin(origins= "*" ,maxAge = 3600)
	@GetMapping("/cartype/{carType}")
	public ResponseEntity<List<Plan>> getAllPlansByCarType(@PathVariable String carType){
		List<Plan> plans=planService.getAllPlansByCarType(carType);
		return new ResponseEntity<List<Plan>>(plans,HttpStatus.OK);
	}
	
}
