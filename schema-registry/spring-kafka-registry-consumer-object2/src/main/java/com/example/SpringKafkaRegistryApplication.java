package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaRegistryApplication {

	final static Logger logger = Logger.getLogger(SpringKafkaRegistryApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaRegistryApplication.class, args);
		ConsumerThread ct1 = new ConsumerThread("employee_test","group1","Consumer-2","latest");
		Thread t1 = new Thread(ct1);
		t1.start();
	}
}
