package com.dev.leandro.tech_interview_two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication(exclude = {XADataSourceAutoConfiguration.class})
public class TechInterviewTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechInterviewTwoApplication.class, args);
	}

}
