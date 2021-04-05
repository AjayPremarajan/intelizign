package com.intelizign.inspectorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${TEST_STATION_URL}")
	private String testStationUrl;
	@Value("${TEST_STATION_PORT}")
	private String testStationPort;

	public void process(EventMember eventMember) {
		try {
			String stationType = restTemplate
					.getForObject(
							"http://" + testStationUrl + ":" + testStationPort + "/testStation/"
									+ eventMember.getEventBody().getProductAttribute().getProductNumber(),
							String.class);
			eventMember.getEventBody().setStationType(stationType);
			eventMember.setSource("INSPECT-ORDER");
			eventMember.setDestination("TEST-STATION");
			eventMemberRepository.save(eventMember);
			log.info("INSPECT-ORDER: Kafka message sent to TEST-STATION for:" + eventMember.getEventId());
			kafkaProducer.sendMessage(eventMember);
		} catch (Exception e) {
			log.error("INSPECT-ORDER: Exception occured:" + e.getMessage());
		}

	}

}
