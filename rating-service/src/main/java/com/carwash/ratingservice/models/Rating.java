package com.carwash.ratingservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rating")
public class Rating {

	@Id
	private int ratingId;
	private int fromCustomerId;
	private int toWasherId;
	private int rating;
	
	
	public int getFromCustomerId() {
		return fromCustomerId;
	}
	public void setFromCustomerId(int fromCustomerId) {
		this.fromCustomerId = fromCustomerId;
	}
	public int getToWasherId() {
		return toWasherId;
	}
	public void setToWasherId(int toWasherId) {
		this.toWasherId = toWasherId;
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
