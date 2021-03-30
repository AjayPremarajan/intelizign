package com.intelizign.sendemail.service;

import org.springframework.stereotype.Service;

import com.intelizign.sendemail.entity.EventMember;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendEmailService {

	public void process(EventMember eventMember) {
		try {
			if (eventMember.getEventBody().getProductAttribute().getResult())
				log.info("SEND-MAIL: The result value was randomly assigned TRUE:" + eventMember.getEventId());
			else
				log.info("SEND-MAIL: The result value was randomly assigned FALSE:" + eventMember.getEventId());
		} catch (Exception e) {
			log.error("Exception occured while processing the request", e);
		}

	}
}
