package com.carwash.zuulsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@Configuration
public class ZuulSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSecurityApplication.class, args);
	}

}
