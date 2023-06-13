package com.userservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UpCommingEventsNotFoundExceptionTest {
    /**
     * Method under test: {@link UpCommingEventsNotFoundException#UpCommingEventsNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        UpCommingEventsNotFoundException actualUpCommingEventsNotFoundException = new UpCommingEventsNotFoundException(
                "An error occurred");
        assertNull(actualUpCommingEventsNotFoundException.getCause());
        assertEquals(0, actualUpCommingEventsNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualUpCommingEventsNotFoundException.getMessage());
        assertEquals("An error occurred", actualUpCommingEventsNotFoundException.getLocalizedMessage());
    }
}

