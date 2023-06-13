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

    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event getEventById(Long eventId) {
        logger.info("Fetching event by ID: {}", eventId);
        return eventRepository.findById(eventId).orElse(null);
    }
}
