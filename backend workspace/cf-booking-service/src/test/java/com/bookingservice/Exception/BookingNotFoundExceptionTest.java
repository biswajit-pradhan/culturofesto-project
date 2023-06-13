package com.bookingservice.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BookingNotFoundExceptionTest {
    /**
     * Method under test: {@link BookingNotFoundException#BookingNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        BookingNotFoundException actualBookingNotFoundException = new BookingNotFoundException("An error occurred");
        assertNull(actualBookingNotFoundException.getCause());
        assertEquals(0, actualBookingNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualBookingNotFoundException.getMessage());
        assertEquals("An error occurred", actualBookingNotFoundException.getLocalizedMessage());
    }
}

