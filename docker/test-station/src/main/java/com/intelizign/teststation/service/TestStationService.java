package com.intelizign.teststation.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelizign.teststation.entity.EventMember;
import com.intelizign.teststation.kafka.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestStationService {
	@Autowired
	private KafkaProducer kafkaProducer;

	public void process(EventMember eventMember) {
		try {
			setRandomBoolean(eventMember);
			eventMember.setDestination("INSPECT-RESULT");
			eventMember.setSource("TEST-STATION");
			log.info("TEST-STATION: Kafka message sent to INSPECT-RESULT for:" + eventMember.getEventId());
			kafkaProducer.sendMessage(eventMember);
		} catch (Exception e) {
			log.error("TEST-STATION: Exception occured:" + e.getMessage()+" for->"+eventMember);
		}
	}

	public void setRandomBoolean(EventMember eventMember) {
		if (eventMember.getEventBody().getProductAttribute().getResult() == null)
			eventMember.getEventBody().getProductAttribute().setResult(new Random().nextBoolean());
		else
			log.info("TEST-STATION: Application logic for Result field bypassed and using actual value for"
					+ eventMember.getEventId());
	}
}
