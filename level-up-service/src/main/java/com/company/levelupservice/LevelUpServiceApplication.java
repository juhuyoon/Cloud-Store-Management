package com.company.levelupservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class LevelUpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LevelUpServiceApplication.class, args);
	}

}
