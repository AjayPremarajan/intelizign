package com.intelizign.teststation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelizign.teststation.entity.EventMember;
import com.intelizign.teststation.service.TestStationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	@Autowired
	private TestStationService testStationService;

	@KafkaListener(topics = "test_inspect_order", groupId = "group_id")
	public void consumeMessage(String message) {
		EventMember eventMember;
		try {
			eventMember = new ObjectMapper().readValue(message, EventMember.class);
			System.out.println("The message received is:" + eventMember);
			testStationService.process(eventMember);
		} catch (JsonProcessingException e) {
			log.error("Exception occured during receiving data from kafka", e);
		}
	}
}
