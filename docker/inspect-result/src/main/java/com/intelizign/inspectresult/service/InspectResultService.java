package com.intelizign.inspectresult.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelizign.inspectresult.entity.EventMember;
import com.intelizign.inspectresult.kafka.KafkaProducer;
import com.intelizign.inspectresult.repository.EventMemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InspectResultService {
	@Autowired
	private KafkaProducer kafkaProducer;
	@Autowired
	private EventMemberRepository eventMemberRepository;

	public void process(EventMember eventMember) {
		try {
			eventMember.setDestination("SEND-MAIL");
			eventMember.setSource("INSPECT-RESULT");
			log.info("INSPECT-RESULT: Sending data to SEND-MAIL for:" + eventMember.getEventId());
			kafkaProducer.sendMessage(eventMember);
			eventMemberRepository.save(eventMember);
		} catch (Exception e) {
			log.error("INSPECT-RESULT: Exception occured:" + e.getMessage()+" for->"+eventMember);
		}

	}
}
