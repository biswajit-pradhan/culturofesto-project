package com.eventservice.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.eventservice.entity.Event;
import com.eventservice.repository.EventServiceRepository;

@ContextConfiguration(classes = {EventServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class EventServiceImplementationTest {
    @Autowired
    private EventServiceImplementation eventServiceImplementation;

    @MockBean
    private EventServiceRepository eventServiceRepository;

    /**
     * Method under test: {@link EventServiceImplementation#getPastEvents()}
     */
    @Test
    void testGetPastEvents() {
        ArrayList<Event> eventList = new ArrayList<>();
        when(eventServiceRepository.findByEventDateBefore(Mockito.<java.util.Date>any())).thenReturn(eventList);
        List<Event> actualPastEvents = eventServiceImplementation.getPastEvents();
        assertSame(eventList, actualPastEvents);
        assertTrue(actualPastEvents.isEmpty());
        verify(eventServiceRepository).findByEventDateBefore(Mockito.<java.util.Date>any());
    }

    /**
     * Method under test: {@link EventServiceImplementation#getFutureEvents()}
     */
    @Test
    void testGetFutureEvents() {
        ArrayList<Event> eventList = new ArrayList<>();
        when(eventServiceRepository.findByEventDateAfter(Mockito.<java.util.Date>any())).thenReturn(eventList);
        List<Event> actualFutureEvents = eventServiceImplementation.getFutureEvents();
        assertSame(eventList, actualFutureEvents);
        assertTrue(actualFutureEvents.isEmpty());
        verify(eventServiceRepository).findByEventDateAfter(Mockito.<java.util.Date>any());
    }

    /**
     * Method under test: {@link EventServiceImplementation#getEventByEventId(Long)}
     */
    @Test
    void testGetEventByEventId() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setEventName("Event Name");
        event.setId(1L);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));

        Optional<Event> ofResult = Optional.of(event);
        when(eventServiceRepository.findById(Mockito.anyLong())).thenReturn(ofResult);

        Event result = (Event) eventServiceImplementation.getEventByEventId(1L);

        assertSame(event, result);
        assertEquals(0, result.getEventImage().length);

        verify(eventServiceRepository).findById(Mockito.anyLong());
    }



}

