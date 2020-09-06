package com.nokia.ms.file.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MsFileServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MsFileServiceApplication.class)
				.properties("spring.config.name:application,db,log", "spring.config.location:classpath:/")
				.build()
				.run(args);

	}

}
