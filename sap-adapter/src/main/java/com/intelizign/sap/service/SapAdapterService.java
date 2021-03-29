package com.intelizign.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelizign.sap.entity.EventBody;
import com.intelizign.sap.entity.EventMember;
import com.intelizign.sap.entity.Message;
import com.intelizign.sap.entity.ProductAttribute;
import com.intelizign.sap.kafka.KafkaProducer;
import com.intelizign.sap.util.Constants;
import com.intelizign.sap.util.EventIdGenerator;
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
		EventBody eventBody;
		try {
			if (Utilities.nullCheck(productAttribute, productAttribute.getProductNumber())) {
				eventBody = EventBody.builder().productAttribute(productAttribute).build();
				eventMember = EventMember.builder().eventId(EventIdGenerator.generate())
						.destination("inspection_order_processing").source("sap-adapter").eventBody(eventBody).build();
				eventMember.setSource("SAP-ADAPTER");
				eventMember.setDestination("INSPECT-ORDER");
				log.info("SAP-ADAPTER: Kafka message sent to INSPECT-ORDER for eventId:" + eventMember.getEventId());
				producer.sendMessage(eventMember);
				message = getSuccess();
				message.setEventId(eventMember.getEventId());
			}
		} catch (Exception e) {
			log.error("SAP-ADAPTER: Exception occured:" + e.getMessage());
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
