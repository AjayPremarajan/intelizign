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
			if (!eventMember.getProductAttribute().getResult()) {
				kafkaProducer.sendMessage(eventMember);
			}
			eventMemberRepository.save(eventMember);
		} catch (Exception e) {
			log.error("Exception occured while processing the request", e);
		}

	}
}
