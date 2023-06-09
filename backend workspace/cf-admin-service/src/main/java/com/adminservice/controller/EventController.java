package com.adminservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.serviceimpl.EventServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class EventController {

	@Autowired
	private EventServiceImpl eventService;
	
	@GetMapping("event/eventlist")
	private ResponseEntity<?> getAllEvents(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.eventService.getAllEvents());
		}catch(NullPointerException e) {
			return ResponseEntity.status(HttpStatus.OK).body("No events are there in the database");
		}
	}
}
