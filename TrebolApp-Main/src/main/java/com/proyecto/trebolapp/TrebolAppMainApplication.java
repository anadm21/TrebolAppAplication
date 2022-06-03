package com.proyecto.trebolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrebolAppMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrebolAppMainApplication.class, args);
	}

}
