package com.intelizign.teststation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelizign.teststation.service.StationTypeService;

@RestController
@RequestMapping("/testStation")
public class TestStationController {
	@Autowired
	private StationTypeService stationTypeService;

	@GetMapping("/{id}")
	public String getStationType(@PathVariable("id") String input) {
		return stationTypeService.getStationType(input);
	}
}
