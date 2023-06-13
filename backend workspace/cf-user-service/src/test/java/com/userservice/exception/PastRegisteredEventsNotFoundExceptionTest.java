package com.userservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PastRegisteredEventsNotFoundExceptionTest {
    /**
     * Method under test: {@link PastRegisteredEventsNotFoundException#PastRegisteredEventsNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        PastRegisteredEventsNotFoundException actualPastRegisteredEventsNotFoundException = new PastRegisteredEventsNotFoundException(
                "An error occurred");
        assertNull(actualPastRegisteredEventsNotFoundException.getCause());
        assertEquals(0, actualPastRegisteredEventsNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualPastRegisteredEventsNotFoundException.getMessage());
        assertEquals("An error occurred", actualPastRegisteredEventsNotFoundException.getLocalizedMessage());
    }
}

