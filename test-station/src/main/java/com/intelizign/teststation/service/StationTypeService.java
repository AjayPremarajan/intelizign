package com.intelizign.teststation.service;

import org.springframework.stereotype.Service;

@Service
public class StationTypeService {
	public String getStationType(String input) {
		return input.replaceAll("[^A-Za-z]+", "");
	}

}
