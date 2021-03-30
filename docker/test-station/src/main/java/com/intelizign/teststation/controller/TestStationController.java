package com.intelizign.teststation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelizign.teststation.service.StationTypeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/testStation")
@Slf4j
public class TestStationController {
	@Autowired
	private StationTypeService stationTypeService;

	@GetMapping("/{id}")
	public String getStationType(@PathVariable("id") String input) {
		log.info("TEST-STATION: Request received for station type for:" + input);
		return stationTypeService.getStationType(input);
	}
}
