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
			log.info("TEST-STATION: Message received:"+eventMember);
			testStationService.process(eventMember);
		} catch (Exception e) {
			log.error("TEST-STATION: Exception occured:" + e.getMessage());
		}
	}
}
