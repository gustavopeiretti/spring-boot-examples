package com.gp.demokafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class DemoKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoKafkaApplication.class, args);
	}

}
