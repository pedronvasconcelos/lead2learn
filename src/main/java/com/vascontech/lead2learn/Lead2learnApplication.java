package com.vascontech.lead2learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan
public class Lead2learnApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lead2learnApplication.class, args);
	}

}
