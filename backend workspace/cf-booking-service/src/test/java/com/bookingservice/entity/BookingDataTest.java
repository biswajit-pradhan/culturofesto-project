package com.bookingservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class BookingDataTest {
    /**
     * Method under test: {@link BookingData#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new BookingData()).canEqual("Other"));
    }

    /**
     * Method under test: {@link BookingData#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertTrue(bookingData.canEqual(bookingData2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingData#BookingData()}
     *   <li>{@link BookingData#setBookingDate(Date)}
     *   <li>{@link BookingData#setEventId(Long)}
     *   <li>{@link BookingData#setId(Long)}
     *   <li>{@link BookingData#setNumberOfAdults(Long)}
     *   <li>{@link BookingData#setNumberOfBreakfast(Long)}
     *   <li>{@link BookingData#setNumberOfChildren(Long)}
     *   <li>{@link BookingData#setNumberOfDinner(Long)}
     *   <li>{@link BookingData#setNumberOfLunch(Long)}
     *   <li>{@link BookingData#setTotalPrice(Double)}
     *   <li>{@link BookingData#setUserId(Long)}
     *   <li>{@link BookingData#toString()}
     *   <li>{@link BookingData#getBookingDate()}
     *   <li>{@link BookingData#getEventId()}
     *   <li>{@link BookingData#getId()}
     *   <li>{@link BookingData#getNumberOfAdults()}
     *   <li>{@link BookingData#getNumberOfBreakfast()}
     *   <li>{@link BookingData#getNumberOfChildren()}
     *   <li>{@link BookingData#getNumberOfDinner()}
     *   <li>{@link BookingData#getNumberOfLunch()}
     *   <li>{@link BookingData#getTotalPrice()}
     *   <li>{@link BookingData#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        BookingData actualBookingData = new BookingData();
        Date bookingDate = mock(Date.class);
        actualBookingData.setBookingDate(bookingDate);
        actualBookingData.setEventId(1L);
        actualBookingData.setId(1L);
        actualBookingData.setNumberOfAdults(1L);
        actualBookingData.setNumberOfBreakfast(1L);
        actualBookingData.setNumberOfChildren(1L);
        actualBookingData.setNumberOfDinner(1L);
        actualBookingData.setNumberOfLunch(1L);
        actualBookingData.setTotalPrice(10.0d);
        actualBookingData.setUserId(1L);
        actualBookingData.toString();
        assertSame(bookingDate, actualBookingData.getBookingDate());
        assertEquals(1L, actualBookingData.getEventId().longValue());
        assertEquals(1L, actualBookingData.getId().longValue());
        assertEquals(1L, actualBookingData.getNumberOfAdults().longValue());
        assertEquals(1L, actualBookingData.getNumberOfBreakfast().longValue());
        assertEquals(1L, actualBookingData.getNumberOfChildren().longValue());
        assertEquals(1L, actualBookingData.getNumberOfDinner().longValue());
        assertEquals(1L, actualBookingData.getNumberOfLunch().longValue());
        assertEquals(10.0d, actualBookingData.getTotalPrice().doubleValue());
        assertEquals(1L, actualBookingData.getUserId().longValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingData#BookingData(Long, Long, Long, Date, Long, Long, Long, Long, Long, Double)}
     *   <li>{@link BookingData#setBookingDate(Date)}
     *   <li>{@link BookingData#setEventId(Long)}
     *   <li>{@link BookingData#setId(Long)}
     *   <li>{@link BookingData#setNumberOfAdults(Long)}
     *   <li>{@link BookingData#setNumberOfBreakfast(Long)}
     *   <li>{@link BookingData#setNumberOfChildren(Long)}
     *   <li>{@link BookingData#setNumberOfDinner(Long)}
     *   <li>{@link BookingData#setNumberOfLunch(Long)}
     *   <li>{@link BookingData#setTotalPrice(Double)}
     *   <li>{@link BookingData#setUserId(Long)}
     *   <li>{@link BookingData#toString()}
     *   <li>{@link BookingData#getBookingDate()}
     *   <li>{@link BookingData#getEventId()}
     *   <li>{@link BookingData#getId()}
     *   <li>{@link BookingData#getNumberOfAdults()}
     *   <li>{@link BookingData#getNumberOfBreakfast()}
     *   <li>{@link BookingData#getNumberOfChildren()}
     *   <li>{@link BookingData#getNumberOfDinner()}
     *   <li>{@link BookingData#getNumberOfLunch()}
     *   <li>{@link BookingData#getTotalPrice()}
     *   <li>{@link BookingData#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        BookingData actualBookingData = new BookingData(1L, 1L, 1L, mock(Date.class), 1L, 1L, 1L, 1L, 1L, 10.0d);
        Date bookingDate = mock(Date.class);
        actualBookingData.setBookingDate(bookingDate);
        actualBookingData.setEventId(1L);
        actualBookingData.setId(1L);
        actualBookingData.setNumberOfAdults(1L);
        actualBookingData.setNumberOfBreakfast(1L);
        actualBookingData.setNumberOfChildren(1L);
        actualBookingData.setNumberOfDinner(1L);
        actualBookingData.setNumberOfLunch(1L);
        actualBookingData.setTotalPrice(10.0d);
        actualBookingData.setUserId(1L);
        actualBookingData.toString();
        assertSame(bookingDate, actualBookingData.getBookingDate());
        assertEquals(1L, actualBookingData.getEventId().longValue());
        assertEquals(1L, actualBookingData.getId().longValue());
        assertEquals(1L, actualBookingData.getNumberOfAdults().longValue());
        assertEquals(1L, actualBookingData.getNumberOfBreakfast().longValue());
        assertEquals(1L, actualBookingData.getNumberOfChildren().longValue());
        assertEquals(1L, actualBookingData.getNumberOfDinner().longValue());
        assertEquals(1L, actualBookingData.getNumberOfLunch().longValue());
        assertEquals(10.0d, actualBookingData.getTotalPrice().doubleValue());
        assertEquals(1L, actualBookingData.getUserId().longValue());
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);
        assertNotEquals(bookingData, null);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals2() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);
        assertNotEquals(bookingData, "Different type to BookingData");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingData#equals(Object)}
     *   <li>{@link BookingData#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);
        assertEquals(bookingData, bookingData);
        int expectedHashCodeResult = bookingData.hashCode();
        assertEquals(expectedHashCodeResult, bookingData.hashCode());
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals4() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals5() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(null);
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals6() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(2L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals7() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(null);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals8() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(2L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals9() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(null);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals10() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(3L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals11() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(null);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals12() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(3L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals13() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(null);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals14() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(3L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals15() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(null);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals16() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(3L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals17() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(null);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals18() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(3L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals19() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(null);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals20() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(null);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals21() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(0.5d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals22() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(2L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals23() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(null);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingData#equals(Object)}
     *   <li>{@link BookingData#hashCode()}
     * </ul>
     */
    @Test
    void testEquals24() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(null);
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(null);
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertEquals(bookingData, bookingData2);
        int expectedHashCodeResult = bookingData.hashCode();
        assertEquals(expectedHashCodeResult, bookingData2.hashCode());
    }

    /**
     * Method under test: {@link BookingData#equals(Object)}
     */
    @Test
    void testEquals25() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(null);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(null);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);
        assertNotEquals(bookingData, bookingData2);
    }
}

