package com.ivisionsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CourseApiDataApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	//This change was made to configure this application so it can be deployed to tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CourseApiDataApplication.class);
	}
}
