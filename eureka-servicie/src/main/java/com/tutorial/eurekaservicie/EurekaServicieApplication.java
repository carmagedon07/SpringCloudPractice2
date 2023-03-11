package com.tutorial.eurekaservicie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServicieApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServicieApplication.class, args);
	}

}
