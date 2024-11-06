package com.jfsd.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ErpprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpprojectApplication.class, args);
		System.out.println("Lets Rock On this Project.....!!!");
	}

}
