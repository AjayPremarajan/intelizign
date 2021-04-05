package com.intelizign.inspectorder.kafka;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelizign.inspectorder.entity.EventMember;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducer {
	private static final String TOPIC = "test_inspect_order";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(EventMember eventMember) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), mapper.writeValueAsString(eventMember));
		} catch (JsonProcessingException e) {
			log.error("INSPECT-ORDER: Exception occured:" + e.getMessage());
		}
	}
}
