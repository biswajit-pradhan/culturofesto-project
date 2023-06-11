package com.eventservice.service;

import java.util.List;

import com.eventservice.entity.Event;

public interface EventService {
	public Event getEventDetailsByEventId(long eventId);
	public List<Event> getPastEvents();
	public List<Event> getFutureEvents();
}
