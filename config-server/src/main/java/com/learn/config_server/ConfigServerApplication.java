package com.learn.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

// Below are two endpoints which will give details
// http://localhost:8888/actuator/default
// http://localhost:8888/actuator/health
// After adding above annotation and application.yml file config server is ready