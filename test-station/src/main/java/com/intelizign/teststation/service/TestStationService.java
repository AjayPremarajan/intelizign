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
			kafkaProducer.sendMessage(eventMember);
		} catch (Exception e) {
			log.error("Exception occured while processing the request", e);
		}
	}

	public void setRandomBoolean(EventMember eventMember) {
		eventMember.getProductAttribute().setResult(new Random().nextBoolean());
	}
}
