package com.feedbackservice.entity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;

class EventTest {
    
    @Test
    void testSetCancelStatus() {
        assertNull((new Event()).setCancelStatus(true));
    }

    
    @Test
    void testSetCancelStatus2() throws UnsupportedEncodingException {
        Date registrationOpenDate = mock(Date.class);
        Date registrationCloseDate = mock(Date.class);
        Date eventDate = mock(Date.class);
        Time eventStartTime = mock(Time.class);
        Time eventCloseTime = mock(Time.class);
        assertNull((new Event(1L, "Event Name", registrationOpenDate, registrationCloseDate, eventDate, eventStartTime,
                eventCloseTime, 10.0d, 1L, 10.0d, 10.0d, 10.0d, true, "AXAXAXAX".getBytes("UTF-8"))).setCancelStatus(true));
    }
}

