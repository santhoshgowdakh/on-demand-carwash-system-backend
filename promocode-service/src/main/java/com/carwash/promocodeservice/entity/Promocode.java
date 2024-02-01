package com.carwash.promocodeservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "promocode")
public class Promocode {
	@Id
	private String promocode;
	private String promocodeDescription;
	private int discount;
	
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public String getPromocodeDescription() {
		return promocodeDescription;
	}
	public void setPromocodeDescription(String promocodeDescription) {
		this.promocodeDescription = promocodeDescription;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
