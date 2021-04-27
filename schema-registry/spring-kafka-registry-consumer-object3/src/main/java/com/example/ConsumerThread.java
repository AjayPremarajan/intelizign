package com.example;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

public class ConsumerThread implements Runnable{
	public ConsumerThread(String topic, String group, String consumerNo, String offsetPolicy) {
		super();
		this.topic = topic;
		this.group = group;
		this.consumerNo = consumerNo;
		this.offsetPolicy = offsetPolicy;
	}
	public String topic;
	public String group;
	public String consumerNo;
	public String offsetPolicy;
	@Override
	public void run() {
			Properties props = new Properties();

			props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			props.put(ConsumerConfig.GROUP_ID_CONFIG, group);


			props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
			props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
			props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
	        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
			props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetPolicy);
			props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

			final Consumer<String, Employee> consumer = new KafkaConsumer<String, Employee>(props);
			consumer.subscribe(Arrays.asList(topic));

			try {
			    System.out.print("Starting the thread "+consumerNo+" .Polling for new message--------------****************>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
			  while (true) {
			    ConsumerRecords<String, Employee> records = consumer.poll(100);
			    for (ConsumerRecord<String, Employee> record : records) {
			    	System.out.println();
			      System.out.printf(consumerNo+":--> offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
			    }
			  }
			} finally {
			  consumer.close();
			}
	}

}
