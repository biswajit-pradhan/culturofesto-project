package com.userservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.userservice.entity.Event;
import com.userservice.repository.BookingManagementRepository;
import com.userservice.repository.EventRepository;
import com.userservice.service.BookingManagementService;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EventServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EventServiceImplTest {
    @MockBean
    private BookingManagementRepository bookingManagementRepository;

    @MockBean
    private BookingManagementService bookingManagementService;

    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private EventServiceImpl eventServiceImpl;

    /**
     * Method under test: {@link EventServiceImpl#getEventsByIds(List)}
     */
    @Test
    void testGetEventsByIds() {
        ArrayList<Event> eventList = new ArrayList<>();
        when(eventRepository.findAllById(Mockito.<Iterable<Long>>any())).thenReturn(eventList);
        List<Event> actualEventsByIds = eventServiceImpl.getEventsByIds(new ArrayList<>());
        assertSame(eventList, actualEventsByIds);
        assertTrue(actualEventsByIds.isEmpty());
        verify(eventRepository).findAllById(Mockito.<Iterable<Long>>any());
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredPastEvent(List)}
     */
    @Test
    void testGetRegisteredPastEvent() {
        assertTrue(eventServiceImpl.getRegisteredPastEvent(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredPastEvent(List)}
     */
    @Test
    void testGetRegisteredPastEvent2() throws UnsupportedEncodingException {
        Date eventDate = mock(Date.class);
        when(eventDate.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Filtering registered past events");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        ArrayList<Event> allRegstdEventDetails = new ArrayList<>();
        allRegstdEventDetails.add(event);
        eventServiceImpl.getRegisteredPastEvent(allRegstdEventDetails);
        verify(eventDate).toLocalDate();
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredPastEvent(List)}
     */
    @Test
    void testGetRegisteredPastEvent3() throws UnsupportedEncodingException {
        Date eventDate = mock(Date.class);
        when(eventDate.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Filtering registered past events");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Date eventDate2 = mock(Date.class);
        when(eventDate2.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event2 = new Event();
        event2.setBreakfastPrice(0.5d);
        event2.setDeleteStatus(false);
        event2.setDinnerPrice(0.5d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(eventDate2);
        event2.setEventImage(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});
        event2.setEventName("Filtered {} registered past events");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(2L);
        event2.setLunchPrice(0.5d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(0.5d);
        event2.setRegistrationOpenDate(mock(Date.class));

        ArrayList<Event> allRegstdEventDetails = new ArrayList<>();
        allRegstdEventDetails.add(event2);
        allRegstdEventDetails.add(event);
        eventServiceImpl.getRegisteredPastEvent(allRegstdEventDetails);
        verify(eventDate2).toLocalDate();
        verify(eventDate).toLocalDate();
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredUpCommingEvent(List)}
     */
    @Test
    void testGetRegisteredUpCommingEvent() {
        assertTrue(eventServiceImpl.getRegisteredUpCommingEvent(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredUpCommingEvent(List)}
     */
    @Test
    void testGetRegisteredUpCommingEvent2() throws UnsupportedEncodingException {
        Date eventDate = mock(Date.class);
        when(eventDate.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Filtering registered upcoming events");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        ArrayList<Event> allRegstdEventDetails = new ArrayList<>();
        allRegstdEventDetails.add(event);
        assertTrue(eventServiceImpl.getRegisteredUpCommingEvent(allRegstdEventDetails).isEmpty());
        verify(eventDate).toLocalDate();
    }

    /**
     * Method under test: {@link EventServiceImpl#getRegisteredUpCommingEvent(List)}
     */
    @Test
    void testGetRegisteredUpCommingEvent3() throws UnsupportedEncodingException {
        Date eventDate = mock(Date.class);
        when(eventDate.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Filtering registered upcoming events");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Date eventDate2 = mock(Date.class);
        when(eventDate2.toLocalDate()).thenReturn(LocalDate.of(1970, 1, 1));

        Event event2 = new Event();
        event2.setBreakfastPrice(0.5d);
        event2.setDeleteStatus(false);
        event2.setDinnerPrice(0.5d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(eventDate2);
        event2.setEventImage(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});
        event2.setEventName("Filtered {} registered upcoming events");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(2L);
        event2.setLunchPrice(0.5d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(0.5d);
        event2.setRegistrationOpenDate(mock(Date.class));

        ArrayList<Event> allRegstdEventDetails = new ArrayList<>();
        allRegstdEventDetails.add(event2);
        allRegstdEventDetails.add(event);
        assertTrue(eventServiceImpl.getRegisteredUpCommingEvent(allRegstdEventDetails).isEmpty());
        verify(eventDate2).toLocalDate();
        verify(eventDate).toLocalDate();
    }
}

