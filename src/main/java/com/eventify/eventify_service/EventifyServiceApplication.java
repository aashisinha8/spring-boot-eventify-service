package com.eventify.eventify_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EventifyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventifyServiceApplication.class, args);
	}

}
