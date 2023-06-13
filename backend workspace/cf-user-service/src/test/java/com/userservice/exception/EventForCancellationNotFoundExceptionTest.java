package com.userservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EventForCancellationNotFoundExceptionTest {
    /**
     * Method under test: {@link EventForCancellationNotFoundException#EventForCancellationNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        EventForCancellationNotFoundException actualEventForCancellationNotFoundException = new EventForCancellationNotFoundException(
                "An error occurred");
        assertNull(actualEventForCancellationNotFoundException.getCause());
        assertEquals(0, actualEventForCancellationNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualEventForCancellationNotFoundException.getMessage());
        assertEquals("An error occurred", actualEventForCancellationNotFoundException.getLocalizedMessage());
    }
}

