package com.userservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.userservice.entity.BookingData;
import com.userservice.entity.Event;
import com.userservice.exception.EventForCancellationNotFoundException;
import com.userservice.service.BookingDataService;
import com.userservice.service.BookingManagementService;
import com.userservice.service.EventService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private BookingDataService bookingDataService;

    @MockBean
    private BookingManagementService bookingManagementService;

    @MockBean
    private EventService eventService;

    @Autowired
    private UserController userController;

    /**
     * Method under test: {@link UserController#cancelEventById(Long, Long)}
     */
    @Test
    void testCancelEventById() throws Exception {
        when(bookingManagementService.cancelEventById(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/user/regstd/cancel/{userid}/{eventId}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link UserController#cancelEventById(Long, Long)}
     */
    @Test
    void testCancelEventById2() throws Exception {
        when(bookingManagementService.cancelEventById(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenThrow(new EventForCancellationNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/user/regstd/cancel/{userid}/{eventId}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Event No. 1 cannot be canceled for user No. 1"));
    }

    /**
     * Method under test: {@link UserController#getBookingDataByUserIdandEventId(Long, Long)}
     */
    @Test
    void testGetBookingDataByUserIdandEventId() throws Exception {
        Date bookingDate = mock(Date.class);
        when(bookingDate.getTime()).thenReturn(10L);
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(bookingDate);
        bookingData.setCustomerType("Customer Type");
        bookingData.setEvent(event);
        bookingData.setFoddOptd(true);
        bookingData.setId(1L);
        bookingData.setNoOfBookings(1);
        when(bookingDataService.getBookingDataByUserIdandEventId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(bookingData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/regstd/event/booking-details/{userid}/{eventid}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"bookingDate\":10,\"customerType\":\"Customer Type\",\"noOfBookings\":1,\"foddOptd\":true,\"event\":{\"id"
                                        + "\":1,\"eventName\":\"Event Name\",\"registrationOpenDate\":10,\"registrationCloseDate\":10,\"eventDate\":10,"
                                        + "\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10"
                                        + ".0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QVhBWEFYQVg=\"}}"));
    }

    /**
     * Method under test: {@link UserController#getUserRegisteredPastEvent(Long)}
     */
    @Test
    void testGetUserRegisteredPastEvent() throws Exception {
        when(bookingManagementService.getAllRegestdEventsBuUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(eventService.getEventsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
        when(eventService.getRegisteredPastEvent(Mockito.<List<Event>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/pst-events/regstd/{userid}",
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No Registered Past Events found for User no. 1"));
    }

    /**
     * Method under test: {@link UserController#getUserRegisteredPastEvent(Long)}
     */
    @Test
    void testGetUserRegisteredPastEvent2() throws Exception {
        when(bookingManagementService.getAllRegestdEventsBuUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        event.setEventName("?");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(eventService.getEventsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
        when(eventService.getRegisteredPastEvent(Mockito.<List<Event>>any())).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/pst-events/regstd/{userid}",
                1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"eventName\":\"?\",\"registrationOpenDate\":10,\"registrationCloseDate\":10,\"eventDate\":10,"
                                        + "\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10"
                                        + ".0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QQFBAUEBQQE=\"}]"));
    }

    /**
     * Method under test: {@link UserController#getUserRegisteredUpCommingEvent(Long)}
     */
    @Test
    void testGetUserRegisteredUpCommingEvent() throws Exception {
        when(bookingManagementService.getAllRegestdEventsBuUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(eventService.getEventsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
        when(eventService.getRegisteredUpCommingEvent(Mockito.<List<Event>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/uc-events/regstd/{userid}",
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No Upcoming Events found for User no. 1"));
    }

    /**
     * Method under test: {@link UserController#getUserRegisteredUpCommingEvent(Long)}
     */
    @Test
    void testGetUserRegisteredUpCommingEvent2() throws Exception {
        when(bookingManagementService.getAllRegestdEventsBuUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        event.setEventName("?");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(eventService.getEventsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
        when(eventService.getRegisteredUpCommingEvent(Mockito.<List<Event>>any())).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/uc-events/regstd/{userid}",
                1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"eventName\":\"?\",\"registrationOpenDate\":10,\"registrationCloseDate\":10,\"eventDate\":10,"
                                        + "\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10"
                                        + ".0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QQFBAUEBQQE=\"}]"));
    }
}

