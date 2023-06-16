package com.feedbackservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.feedbackservice.role.Role;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FeedbackTest {
    
    @Test
    void testCanEqual() {
        assertFalse((new Feedback()).canEqual("Other"));
    }

    
    @Test
    void testCanEqual2() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");

        Feedback feedback2 = new Feedback();
        feedback2.setEvent(event2);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUser(user2);
        assertTrue(feedback.canEqual(feedback2));
    }

   
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        Feedback actualFeedback = new Feedback();
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        actualFeedback.setEvent(event);
        actualFeedback.setFeedbackText("Feedback Text");
        actualFeedback.setId(1L);
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        actualFeedback.setUser(user);
        actualFeedback.toString();
        assertSame(event, actualFeedback.getEvent());
        assertEquals("Feedback Text", actualFeedback.getFeedbackText());
        assertEquals(1L, actualFeedback.getId().longValue());
        assertSame(user, actualFeedback.getUser());
    }

   
    @Test
    void testConstructor2() throws UnsupportedEncodingException {
        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Feedback actualFeedback = new Feedback(1L, user, event, "Feedback Text");
        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        actualFeedback.setEvent(event2);
        actualFeedback.setFeedbackText("Feedback Text");
        actualFeedback.setId(1L);
        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        actualFeedback.setUser(user2);
        actualFeedback.toString();
        assertSame(event2, actualFeedback.getEvent());
        assertEquals("Feedback Text", actualFeedback.getFeedbackText());
        assertEquals(1L, actualFeedback.getId().longValue());
        User user3 = actualFeedback.getUser();
        assertSame(user2, user3);
        assertEquals(user, user3);
    }

   
    @Test
    void testEquals() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);
        assertNotEquals(feedback, null);
    }

    
    @Test
    void testEquals2() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);
        assertNotEquals(feedback, "Different type to Feedback");
    }

   
    @Test
    void testEquals3() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);
        assertEquals(feedback, feedback);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback.hashCode());
    }

  
    @Test
    void testEquals4() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");

        Feedback feedback2 = new Feedback();
        feedback2.setEvent(event2);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUser(user2);
        assertNotEquals(feedback, feedback2);
    }

    
    @Test
    void testEquals5() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(2L);
        feedback.setUser(user);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");

        Feedback feedback2 = new Feedback();
        feedback2.setEvent(event2);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUser(user2);
        assertNotEquals(feedback, feedback2);
    }

    
    @Test
    void testEquals6() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(null);
        feedback.setUser(user);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");

        Feedback feedback2 = new Feedback();
        feedback2.setEvent(event2);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUser(user2);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals7() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        User user = mock(User.class);
        doNothing().when(user).setId(Mockito.<Long>any());
        doNothing().when(user).setRole(Mockito.<Role>any());
        doNothing().when(user).setUserEmail(Mockito.<String>any());
        doNothing().when(user).setUserName(Mockito.<String>any());
        doNothing().when(user).setUserPassword(Mockito.<String>any());
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.USER);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");

        Feedback feedback2 = new Feedback();
        feedback2.setEvent(event2);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUser(user2);
        assertNotEquals(feedback, feedback2);
    }
}

