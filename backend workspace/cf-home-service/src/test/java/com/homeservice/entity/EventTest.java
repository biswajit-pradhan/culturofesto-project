package com.homeservice.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class EventTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Event#Event()}
     *   <li>{@link Event#isEmpty()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertFalse((new Event()).isEmpty());
    }
}

