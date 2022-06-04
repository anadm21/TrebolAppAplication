package com.proyecto.trebolappeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableEurekaServer --> Anotación para definir el servidor Eureka
@EnableEurekaServer
@SpringBootApplication
public class TrebolAppEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrebolAppEurekaApplication.class, args);
	}

}
