package com.eventservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventservice.entity.Event;
import com.eventservice.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventServiceController {
    
	@Autowired
	private EventService eventService;


	@GetMapping("/{eventId}")
	public ResponseEntity<Event> getEventDetailsByEventId(@PathVariable("eventId") long eventId) {
		Event event = eventService.getEventDetailsByEventId(eventId);
		if (event == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(event);
	}
	
	 @GetMapping("/past")
	    public ResponseEntity<List<Event>> getPastEvents() {
	        List<Event> pastEvents = eventService.getPastEvents();
	        return ResponseEntity.ok(pastEvents);
	    }
	 
	 @GetMapping("/future")
	    public ResponseEntity<List<Event>> getFutureEvents() {
	        List<Event> futureEvents = eventService.getFutureEvents();
	        return ResponseEntity.ok(futureEvents);
	    }
	
}



