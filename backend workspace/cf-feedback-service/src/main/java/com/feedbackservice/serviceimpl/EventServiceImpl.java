package com.feedbackservice.serviceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackservice.entity.Event;
import com.feedbackservice.repository.EventRepository;
import com.feedbackservice.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	// Logger instance for logging events in the EventServiceImpl class
	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);


    @Autowired
    EventRepository eventRepository;

    @Override
    public Event getEventById(Long eventId) {
    	LOGGER.info("Fetching event by ID: {}", eventId);
        return eventRepository.findById(eventId).orElse(null);
    }
}
