package com.exercise.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * RestController for parking reservation application.
 * 
 * @author ashish
 *
 */

@RestController
@SpringBootApplication(scanBasePackages="com.exercise.parking")
@PropertySource({"classpath:parking.properties"})
public class ParkingController {

	Logger logger=LoggerFactory.getLogger(ParkingController.class);
	

	@RequestMapping(method=RequestMethod.GET, value = "/availableParkingSlots")
	public String getAvailableParkingSlots(@RequestParam(value = "lat") String latitude,
			@RequestParam(value = "long") String longitude, @RequestParam(value = "radius") String radius) {
		logger.info(
				"Request received to retrieve available parking slots with location as latitude: {}, longitude:{}, radius:{}",
				latitude, longitude, radius);

		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/reserveParkingSlot")
	public String reserveParkingSlot(@RequestParam(value = "lat") String latitude,
			@RequestParam(value = "long") String longitude) {
		logger.info(
				"Request received to reserve a parking slot at latitude: {}, longitude:{}",
				latitude, longitude);

		return null;
	}
	

	@RequestMapping(method=RequestMethod.GET, value = "/cancelParkingSlot")
	public String cancelReservedParkingSlot(@RequestParam(value = "lat") String latitude,
			@RequestParam(value = "long") String longitude) {
		
		logger.info(
				"Request received to cancel the reserved parking slot at latitude: {}, longitude:{}",
				latitude, longitude);

		return null;
	}

	
	/*
	 * Bootstraps the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(ParkingController.class, args);
	}


}
