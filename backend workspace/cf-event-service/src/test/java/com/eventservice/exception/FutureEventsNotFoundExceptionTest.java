package com.eventservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class FutureEventsNotFoundExceptionTest {
    /**
     * Method under test: {@link FutureEventsNotFoundException#FutureEventsNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        FutureEventsNotFoundException actualFutureEventsNotFoundException = new FutureEventsNotFoundException(
                "An error occurred");
        assertNull(actualFutureEventsNotFoundException.getCause());
        assertEquals(0, actualFutureEventsNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualFutureEventsNotFoundException.getMessage());
        assertEquals("An error occurred", actualFutureEventsNotFoundException.getLocalizedMessage());
    }
}

