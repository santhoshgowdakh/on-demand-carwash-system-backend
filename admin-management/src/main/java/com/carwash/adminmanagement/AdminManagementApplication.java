package com.carwash.adminmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminManagementApplication.class, args);
	}

}
