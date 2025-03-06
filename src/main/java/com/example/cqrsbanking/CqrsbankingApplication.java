package com.example.cqrsbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CqrsbankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsbankingApplication.class, args);
	}

}
