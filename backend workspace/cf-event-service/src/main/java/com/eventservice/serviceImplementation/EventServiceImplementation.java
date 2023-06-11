package com.eventservice.serviceImplementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventservice.entity.Event;
import com.eventservice.repository.EventServiceRepository;
import com.eventservice.service.EventService;

@Service
public class EventServiceImplementation implements EventService {

	@Autowired
    private EventServiceRepository eventRepository;


    public Event getEventDetailsByEventId(long eventId) {
        return eventRepository.findById(eventId);
    }
    
    public List<Event> getPastEvents() {
        Date currentDate = new Date(System.currentTimeMillis());
        return eventRepository.findByRegistrationCloseDateBefore(currentDate);
    }

    public List<Event> getFutureEvents() {
        Date currentDate = new Date(System.currentTimeMillis());
        return eventRepository.findByRegistrationCloseDateAfter(currentDate);
    }
}
