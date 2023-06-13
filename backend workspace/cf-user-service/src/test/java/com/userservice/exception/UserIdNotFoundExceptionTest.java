package com.userservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UserIdNotFoundExceptionTest {
    /**
     * Method under test: {@link UserIdNotFoundException#UserIdNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        UserIdNotFoundException actualUserIdNotFoundException = new UserIdNotFoundException("An error occurred");
        assertNull(actualUserIdNotFoundException.getCause());
        assertEquals(0, actualUserIdNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualUserIdNotFoundException.getMessage());
        assertEquals("An error occurred", actualUserIdNotFoundException.getLocalizedMessage());
    }
}

