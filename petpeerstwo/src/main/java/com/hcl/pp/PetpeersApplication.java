package com.hcl.pp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetpeersApplication {

	private static final Logger LOGGER = LogManager.getLogger(PetpeersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetpeersApplication.class, args);
		LOGGER.info("Application Main Method Start");
	}

}
