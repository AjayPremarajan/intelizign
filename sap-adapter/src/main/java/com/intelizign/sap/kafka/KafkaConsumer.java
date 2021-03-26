package com.intelizign.sap.kafka;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelizign.sap.entity.EventMember;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	//uncomment for testing KafkaListener(topics = "test_sap_adapter", groupId = "group-id")
	public void consumeMessage(String message) {
		EventMember eventMember;
		try {
			eventMember = new ObjectMapper().readValue(message, EventMember.class);
			System.out.println("The message received is:" + eventMember);
		} catch (JsonProcessingException e) {
			log.error("Exception occured during receiving data from kafka", e);
		}
	}
}
