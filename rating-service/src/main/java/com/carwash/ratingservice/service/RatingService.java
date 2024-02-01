package com.carwash.ratingservice.service;

import java.util.List;

import com.carwash.ratingservice.models.Rating;

public interface RatingService {

	int addRating(Rating rating);
	Rating getRatingByRatingId(int ratingId);
	List<Rating> getAllRatings();
	void deleteRatingByRatingId(int ratingId);
}
