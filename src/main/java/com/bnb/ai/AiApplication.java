package com.bnb.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class AiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AiApplication.class, args);
		int counter = 0;
		while (true) {
			counter++;
			ServiceA serviceA = new ServiceA(new ServiceB(new ServiceC()));
			serviceA.sendData(UUID.randomUUID().toString(), "Processing data", "Service C");
		}
	}

}
