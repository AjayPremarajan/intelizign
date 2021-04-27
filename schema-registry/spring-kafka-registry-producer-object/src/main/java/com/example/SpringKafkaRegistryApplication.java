package com.example;

import java.util.Properties;

import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

@SpringBootApplication
@RestController
public class SpringKafkaRegistryApplication {
	final static Logger logger = Logger.getLogger(SpringKafkaRegistryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaRegistryApplication.class, args);

	}

	@RequestMapping("/doIt")
	public static String doIt() {
		ProducerThread p1 = new ProducerThread("localhost:9092", "1");
		Thread t1 = new Thread(p1);
		t1.start();
		return "Thread started for the request";
	}
}
