package com.intelizign.sap.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelizign.sap.entity.Message;
import com.intelizign.sap.entity.ProductAttribute;
import com.intelizign.sap.service.SapAdapterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SapAdapterController {
	@Autowired
	private SapAdapterService sapAdapterService;
	@RequestMapping("/")
	public void redirectSwagger(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	@PostMapping("/sap")
	public Message process(@RequestBody ProductAttribute productAttribute) {
		log.info("SAP-ADAPTER: Received request for processing ->"+productAttribute);
		return sapAdapterService.process(productAttribute);
	}
}
