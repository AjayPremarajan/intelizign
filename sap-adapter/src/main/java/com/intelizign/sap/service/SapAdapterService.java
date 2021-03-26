package com.intelizign.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelizign.sap.entity.EventMember;
import com.intelizign.sap.entity.Message;
import com.intelizign.sap.entity.ProductAttribute;
import com.intelizign.sap.kafka.KafkaProducer;
import com.intelizign.sap.util.Constants;
import com.intelizign.sap.util.Sha256;
import com.intelizign.sap.util.Utilities;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SapAdapterService {
	@Autowired
	private KafkaProducer producer;

	public Message process(ProductAttribute productAttribute) {
		Message message = getFailure();
		EventMember eventMember;
		try {
			if (Utilities.nullCheck(productAttribute)) {
				eventMember = EventMember.builder().event_id(Sha256.computeGeneratedId(productAttribute))
						.scope("inspection_order_processing").source("sap-adapter").build();
				eventMember.setProductAttribute(productAttribute);
				log.info("Processing data for:" + eventMember.getEvent_id());
				log.info(eventMember.getSource() + "---->" + eventMember.getScope());
				producer.sendMessage(eventMember);
				log.info("Kafka Message sent successfully for:" + eventMember.getEvent_id());
				message = getSuccess();
			}
		} catch (Exception e) {
			log.error("Exception occured while sending data to kafka", e);
			message.setResponesMessage(e.getMessage());
		}
		return message;
	}

	public Message getSuccess() {
		Message message = new Message();
		message.setResponesMessage(Constants.SUCCESS_MESSAGE);
		message.setResponseCode(Constants.SUCCESS_CODE);
		return message;
	}

	public Message getFailure() {
		Message message = new Message();
		message.setResponesMessage(Constants.INTERNAL_SERVER_ERROR);
		message.setResponseCode(Constants.FAILURE_CODE);
		return message;
	}
}
