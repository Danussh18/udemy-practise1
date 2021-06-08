package com.example.udemypractise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdemyPractise1Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(UdemyPractise1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(UdemyPractise1Application.class, args);
		logger.info("--------inside Main Method----------");
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
