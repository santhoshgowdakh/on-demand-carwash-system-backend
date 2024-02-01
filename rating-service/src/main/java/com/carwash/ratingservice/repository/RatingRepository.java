package com.carwash.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.carwash.ratingservice.models.Rating;

public interface RatingRepository extends MongoRepository<Rating, Integer> {

	@Query("{ratingId:?0}")
	Rating getRatingByRatingId(int ratingId);
	
	@Query("{rating:?0}")
	List<Rating> getRatingsByRating(int rating);
}
