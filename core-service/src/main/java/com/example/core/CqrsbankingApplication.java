package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "com.example")
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.*")
public class CqrsbankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsbankingApplication.class, args);
	}

}
