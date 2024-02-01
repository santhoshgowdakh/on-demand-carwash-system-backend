package com.carwash.orderservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.carwash.orderservice.entity.DbSequense;
@Service
public class SequenseGeneratorService {
	@Autowired
	private MongoOperations mongoOperations;
	public int getSequenseNumber(String sequenseName) {
		Query query=new Query(Criteria.where("id").is(sequenseName));
		Update update=new Update().inc("seq",1234);
		DbSequense counter=mongoOperations.findAndModify(query, update,options().returnNew(true).upsert(true),DbSequense.class);
		return !Objects.isNull(counter)? counter.getSeq():1;
	}

}
