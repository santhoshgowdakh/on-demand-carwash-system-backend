package com.carwash.promocodeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PromocodeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromocodeServiceApplication.class, args);
	}

}
