package com.intelizign.inspectresult.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelizign.inspectresult.entity.EventMember;
import com.intelizign.inspectresult.service.InspectResultService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	@Autowired
	private InspectResultService testStationService;

	@KafkaListener(topics = "test_test_station", groupId = "group_id")
	public void consumeMessage(String message) {
		EventMember eventMember;
		try {
			eventMember = new ObjectMapper().readValue(message, EventMember.class);
			log.info("INSPECT-RESULT: Kafka Message received:"+eventMember);
			testStationService.process(eventMember);
		} catch (Exception e) {
			log.error("INSPECT-RESULT: Exception occured:"+e.getMessage());
		}
	}
}
