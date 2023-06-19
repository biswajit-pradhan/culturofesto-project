package com.bookingservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import com.bookingservice.enums.PaymentMethod;

import java.math.BigInteger;
import java.sql.Date;

import org.junit.jupiter.api.Test;

class PaymentDataTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentData#PaymentData()}
     *   <li>{@link PaymentData#setBookingId(Long)}
     *   <li>{@link PaymentData#setCardNumber(BigInteger)}
     *   <li>{@link PaymentData#setCvvNumber(Integer)}
     *   <li>{@link PaymentData#setExpiryDate(Date)}
     *   <li>{@link PaymentData#setId(Long)}
     *   <li>{@link PaymentData#setPaymentMethod(PaymentMethod)}
     *   <li>{@link PaymentData#setTotalPrice(Double)}
     *   <li>{@link PaymentData#toString()}
     *   <li>{@link PaymentData#getBookingId()}
     *   <li>{@link PaymentData#getCardNumber()}
     *   <li>{@link PaymentData#getCvvNumber()}
     *   <li>{@link PaymentData#getExpiryDate()}
     *   <li>{@link PaymentData#getId()}
     *   <li>{@link PaymentData#getPaymentMethod()}
     *   <li>{@link PaymentData#getTotalPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PaymentData actualPaymentData = new PaymentData();
        actualPaymentData.setBookingId(1L);
        BigInteger cardNumber = BigInteger.valueOf(1L);
        actualPaymentData.setCardNumber(cardNumber);
        actualPaymentData.setCvvNumber(10);
        Date expiryDate = mock(Date.class);
        actualPaymentData.setExpiryDate(expiryDate);
        actualPaymentData.setId(1L);
        actualPaymentData.setPaymentMethod(PaymentMethod.CREDIT);
        actualPaymentData.setTotalPrice(10.0d);
        actualPaymentData.toString();
        assertEquals(1L, actualPaymentData.getBookingId().longValue());
        BigInteger expectedCardNumber = cardNumber.ONE;
        assertSame(expectedCardNumber, actualPaymentData.getCardNumber());
        assertEquals(10, actualPaymentData.getCvvNumber().intValue());
        assertSame(expiryDate, actualPaymentData.getExpiryDate());
        assertEquals(1L, actualPaymentData.getId().longValue());
        assertEquals(PaymentMethod.CREDIT, actualPaymentData.getPaymentMethod());
        assertEquals(10.0d, actualPaymentData.getTotalPrice().doubleValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentData#PaymentData(Long, Long, PaymentMethod, BigInteger, Date, Integer, Double)}
     *   <li>{@link PaymentData#setBookingId(Long)}
     *   <li>{@link PaymentData#setCardNumber(BigInteger)}
     *   <li>{@link PaymentData#setCvvNumber(Integer)}
     *   <li>{@link PaymentData#setExpiryDate(Date)}
     *   <li>{@link PaymentData#setId(Long)}
     *   <li>{@link PaymentData#setPaymentMethod(PaymentMethod)}
     *   <li>{@link PaymentData#setTotalPrice(Double)}
     *   <li>{@link PaymentData#toString()}
     *   <li>{@link PaymentData#getBookingId()}
     *   <li>{@link PaymentData#getCardNumber()}
     *   <li>{@link PaymentData#getCvvNumber()}
     *   <li>{@link PaymentData#getExpiryDate()}
     *   <li>{@link PaymentData#getId()}
     *   <li>{@link PaymentData#getPaymentMethod()}
     *   <li>{@link PaymentData#getTotalPrice()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        PaymentData actualPaymentData = new PaymentData(1L, 1L, PaymentMethod.CREDIT, BigInteger.valueOf(1L),
                mock(Date.class), 10, 10.0d);
        actualPaymentData.setBookingId(1L);
        BigInteger cardNumber = BigInteger.valueOf(1L);
        actualPaymentData.setCardNumber(cardNumber);
        actualPaymentData.setCvvNumber(10);
        Date expiryDate = mock(Date.class);
        actualPaymentData.setExpiryDate(expiryDate);
        actualPaymentData.setId(1L);
        actualPaymentData.setPaymentMethod(PaymentMethod.CREDIT);
        actualPaymentData.setTotalPrice(10.0d);
        actualPaymentData.toString();
        assertEquals(1L, actualPaymentData.getBookingId().longValue());
        BigInteger expectedCardNumber = cardNumber.ONE;
        assertSame(expectedCardNumber, actualPaymentData.getCardNumber());
        assertEquals(10, actualPaymentData.getCvvNumber().intValue());
        assertSame(expiryDate, actualPaymentData.getExpiryDate());
        assertEquals(1L, actualPaymentData.getId().longValue());
        assertEquals(PaymentMethod.CREDIT, actualPaymentData.getPaymentMethod());
        assertEquals(10.0d, actualPaymentData.getTotalPrice().doubleValue());
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        assertNotEquals(paymentData, null);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals2() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        assertNotEquals(paymentData, "Different type to PaymentData");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentData#equals(Object)}
     *   <li>{@link PaymentData#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        assertEquals(paymentData, paymentData);
        int expectedHashCodeResult = paymentData.hashCode();
        assertEquals(expectedHashCodeResult, paymentData.hashCode());
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals4() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals5() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(2L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals6() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(null);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals7() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(3L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals8() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(null);
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals9() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(1);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals10() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(null);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals11() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(null);
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals12() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(2L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals13() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(null);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals14() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(null);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals15() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.DEBIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals16() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(null);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals17() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(0.5d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals18() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(null);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(null);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }

    /**
     * Method under test: {@link PaymentData#equals(Object)}
     */
    @Test
    void testEquals19() {
        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(null);
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(null);
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertNotEquals(paymentData, paymentData2);
    }
}

