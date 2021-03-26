package com.intelizign.inspectresult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InspectResultApplication {

	public static void main(String[] args) {
		SpringApplication.run(InspectResultApplication.class, args);
	}
}
