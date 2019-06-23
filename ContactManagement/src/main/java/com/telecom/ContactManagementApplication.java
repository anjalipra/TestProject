package com.telecom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telecom.service.ContactServiceImpl;

@SpringBootApplication
public class ContactManagementApplication {
	private static final Logger logger = LogManager.getLogger(ContactManagementApplication.class);
	
	public static void main(String[] args) {
		logger.info("Starting the application.");
		SpringApplication.run(ContactManagementApplication.class, args);
	}

}
