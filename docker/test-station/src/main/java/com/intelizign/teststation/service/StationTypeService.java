package com.intelizign.teststation.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StationTypeService {
	public String getStationType(String input) {
		String result = "EXCEPTION";

		try {
			result = input.replaceAll("[^A-Za-z]+", "");
		} catch (Exception e) {
			log.error("TEST-STATION: Exception occured:" + e.getMessage());
		}
		return result;
	}

}
