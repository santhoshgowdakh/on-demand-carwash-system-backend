package com.carwash.apigatewaysecurity;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.client.RestTemplate;

import com.carwash.apigatewaysecurity.util.JwtUtil;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewaySecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaySecurityApplication.class, args);
		
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public ServerProperties getserver() {
//		return new ServerProperties();
//	}
//	@Bean
//	public ServerCodecConfigurer getserverCon() {
//		return ServerCodecConfigurer.create();
//	}
	

}
