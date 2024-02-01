package com.carwash.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.ratingservice.models.Rating;
import com.carwash.ratingservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository ratingRepository;
	
	
	
	@Override
	public Rating getRatingByRatingId(int ratingId) {
		return ratingRepository.getRatingByRatingId(ratingId);
		
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public int addRating(Rating rating) {
		ratingRepository.save(rating);
		return rating.getRatingId();
	}

	@Override
	public void deleteRatingByRatingId(int ratingId) {
		// TODO Auto-generated method stub
		
	}

}
