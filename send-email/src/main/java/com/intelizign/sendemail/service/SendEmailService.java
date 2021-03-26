package com.intelizign.sendemail.service;

import org.springframework.stereotype.Service;

import com.intelizign.sendemail.entity.EventMember;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendEmailService {

	public void process(EventMember eventMember) {
		try {
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("The recieved data:"+eventMember);
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			log.info("----------------------------------------------------");
			
		} catch (Exception e) {
			log.error("Exception occured while processing the request", e);
		}

	}
}
