package com.carwash.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="db_order_sequense")
public class DbSequense {
	@Id
	private String id;
	private int seq;
	public DbSequense() {}

	public DbSequense(String id, int seq) {
		this.id = id;
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	
	
	

}
