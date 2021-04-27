package com.example;

import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;

import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

public class ProducerThread implements Runnable {

	public ProducerThread(String url, String clientNo) {
		super();
		this.url = url;
		this.clientNo = clientNo;
	}
	public String url;
	public String clientNo;
	@Override
	public void run() {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, url);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, clientNo);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				org.apache.kafka.common.serialization.StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
		props.put(KafkaAvroSerializerConfig.AUTO_REGISTER_SCHEMAS, "true");
		KafkaProducer producer = new KafkaProducer(props);
		try {
			for(int i=0;i<3;i++) {
				String key =UUID.randomUUID().toString();
				Employee employee = Employee.newBuilder().setFirstName("Ajay->"+clientNo).setLastName("Premarajan").setAge(Integer.toString(i))
						.build();
				ProducerRecord<String, Employee> record = new ProducerRecord<>("employee_test", key, employee);
					
				producer.send(record);
			}
		} catch (SerializationException e) {
			// may need to do something with it
		}
		// When you're finished producing records, you can flush the producer to ensure
		// it has all been written to Kafka and
		// then close the producer to free its resources.
		finally {
			producer.flush();
			producer.close();
		}
			
	}

}
