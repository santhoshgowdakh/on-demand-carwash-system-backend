package com.carwash.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.ratingservice.models.Rating;
import com.carwash.ratingservice.service.RatingService;

@CrossOrigin(origins= "*" ,maxAge = 3600)
@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addRating(@RequestBody Rating rating){
		int ratingId=ratingService.addRating(rating);
		return new ResponseEntity<String>("Rating added ID: "+ratingId,HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Rating>> addPromocode(){
		List<Rating> ratingsList=ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratingsList,HttpStatus.OK);
	}
	@GetMapping("/id/{ratingId}")
	public ResponseEntity<Rating> getRatingByRatingId(@PathVariable int ratingId){
		Rating rating=ratingService.getRatingByRatingId(ratingId);
		return new ResponseEntity<Rating>(rating,HttpStatus.OK);
	}
}
