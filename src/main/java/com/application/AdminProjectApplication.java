package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class AdminProjectApplication {

	public static void main(String[] args) {
		final ApplicationContext context =   SpringApplication.run(AdminProjectApplication.class, args);
	}
	
}
