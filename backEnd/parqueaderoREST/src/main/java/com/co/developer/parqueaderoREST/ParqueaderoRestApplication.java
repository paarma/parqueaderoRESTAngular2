package com.co.developer.parqueaderoREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.co.developer.parqueaderoREST.dao")
@SpringBootApplication
public class ParqueaderoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParqueaderoRestApplication.class, args);
	}
}
