package com.intelizign.inspectorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intelizign.inspectorder.entity.EventMember;
import com.intelizign.inspectorder.kafka.KafkaProducer;
import com.intelizign.inspectorder.repository.EventMemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InspectOrderService {

	@Autowired
	private KafkaProducer kafkaProducer;
	@Autowired
	private EventMemberRepository eventMemberRepository;
	@Autowired
	private RestTemplate restTemplate;
	public void process(EventMember eventMember) {
		try {
			eventMember.setStationType(restTemplate.getForObject("http://test-station:1236/testStation/"+eventMember.getProductAttribute().getProductNumber(),String.class));
			eventMemberRepository.save(eventMember);
			kafkaProducer.sendMessage(eventMember);
		} catch (Exception e) {
			log.error("Exception occured while processing the request", e);
		}

	}

}
