package com.intelizign.inspectorder.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelizign.inspectorder.entity.EventMember;
import com.intelizign.inspectorder.service.InspectOrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	@Autowired
	private InspectOrderService inspectOrderService;

	@KafkaListener(topics = "test_sap_adapter", groupId = "group_id")
	public void consumeMessage(String message) {
		EventMember eventMember;
		try {
			eventMember = new ObjectMapper().readValue(message, EventMember.class);
			log.info("INSPECT-ORDER: Received message:"+eventMember);
			inspectOrderService.process(eventMember);
		} catch (JsonProcessingException e) {
			log.error("INSPECT-ORDER: Exception occured:" + e.getMessage());
		}
	}
}
