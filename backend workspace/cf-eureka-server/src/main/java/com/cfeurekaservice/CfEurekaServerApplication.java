package com.cfeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CfEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfEurekaServerApplication.class, args);
	}

}
