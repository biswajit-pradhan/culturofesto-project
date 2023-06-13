package com.homeservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.homeservice.entity.Event;
import com.homeservice.exception.EventNotFoundException;
import com.homeservice.repo.EventRepository;
import com.homeservice.utils.ImageUtils;

@SpringBootTest
public class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEvents() {
        // Mock data
        List<Event> events = new ArrayList<>();
        events.add(createEvent(1L, "Event 1"));
        events.add(createEvent(2L, "Event 2"));
        events.add(createEvent(3L, "Event 3"));

        // Mock repository
        when(eventRepository.findAll()).thenReturn(events);

        // Mock ImageUtils
        when(ImageUtils.decompressImage(any(byte[].class))).thenReturn(new byte[]{});

        // Call service method
        List<Event> result = eventService.getAllEvents();

        // Verify the result
        assertEquals(3, result.size());
        assertEquals("Event 1", result.get(0).getEventName());
        assertEquals("Event 2", result.get(1).getEventName());
        assertEquals("Event 3", result.get(2).getEventName());
    }

    @Test
    public void testGetEventByEventId_ExistingEventId() {
        // Mock data
        Long eventId = 1L;
        Event event = createEvent(eventId, "Event 1");

        // Mock repository
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Mock ImageUtils
        when(ImageUtils.decompressImage(any(byte[].class))).thenReturn(new byte[]{});

        // Call service method
        Event result = (Event) eventService.getEventByEventId(eventId);

        // Verify the result
        assertEquals(eventId, result.getId());
        assertEquals("Event 1", result.getEventName());
    }

    @Test
    public void testGetEventByEventId_NonExistingEventId() {
        // Mock data
        Long eventId = 100L;

        // Mock repository
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        // Call service method and verify that it throws the expected exception
        assertThrows(EventNotFoundException.class, () -> eventService.getEventByEventId(eventId));
    }

    // Helper method to create an Event object
    private Event createEvent(Long id, String eventName) {
        Event event = new Event();
        event.setId(id);
        event.setEventName(eventName);
        event.setEventDate(new Date(System.currentTimeMillis()));
        event.setRegistrationOpenDate(new Date(System.currentTimeMillis()));
        event.setRegistrationCloseDate(new Date(System.currentTimeMillis()));
        event.setEventStartTime(new Time(System.currentTimeMillis()));
        event.setEventCloseTime(new Time(System.currentTimeMillis()));
        event.setRegistrationFee(10.0);
        event.setEventCapacity(100L);
        event.setBreakfastPrice(5.0);
        event.setLunchPrice(10.0);
        event.setDinnerPrice(15.0);
        event.setDeleteStatus(Boolean.FALSE);
        event.setEventImage(new byte[]{});

        return event;
    }
}
