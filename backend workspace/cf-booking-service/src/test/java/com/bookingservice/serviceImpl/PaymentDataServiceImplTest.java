package com.bookingservice.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bookingservice.entity.BookingData;
import com.bookingservice.entity.PaymentData;
import com.bookingservice.enums.PaymentMethod;
import com.bookingservice.repository.BookingDataRepository;
import com.bookingservice.repository.PaymentDataRepository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaymentDataServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PaymentDataServiceImplTest {
    @MockBean
    private BookingDataRepository bookingDataRepository;

    @MockBean
    private PaymentDataRepository paymentDataRepository;

    @Autowired
    private PaymentDataServiceImpl paymentDataServiceImpl;

    @Test
    void testGetPaymentDataByBookingId() {
        when(paymentDataRepository.findAll()).thenReturn(new ArrayList<>());
        assertNull(paymentDataServiceImpl.getPaymentDataByBookingId(1L));
        verify(paymentDataRepository).findAll();
    }


  


   


    @Test
    void testAddPaymentDataByBookingId() {
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
        Optional<BookingData> ofResult = Optional.of(bookingData);
        when(bookingDataRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        when(paymentDataRepository.save(Mockito.<PaymentData>any())).thenReturn(paymentData);
        when(paymentDataRepository.findAll()).thenReturn(new ArrayList<>());

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingId(1L);
        paymentData2.setCardNumber(BigInteger.valueOf(1L));
        paymentData2.setCvvNumber(10);
        paymentData2.setExpiryDate(mock(Date.class));
        paymentData2.setId(1L);
        paymentData2.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData2.setTotalPrice(10.0d);
        assertEquals("Payment data added successfully", paymentDataServiceImpl.addPaymentDataByBookingId(paymentData2, 1L));
        verify(bookingDataRepository).findById(Mockito.<Long>any());
        verify(paymentDataRepository).save(Mockito.<PaymentData>any());
        verify(paymentDataRepository).findAll();
        assertEquals(1L, paymentData2.getBookingId().longValue());
        assertEquals(10.0d, paymentData2.getTotalPrice().doubleValue());
    }


    @Test
    void testAddPaymentDataByBookingId3() {
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
        Optional<BookingData> ofResult = Optional.of(bookingData);
        when(bookingDataRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        ArrayList<PaymentData> paymentDataList = new ArrayList<>();
        paymentDataList.add(paymentData2);
        when(paymentDataRepository.save(Mockito.<PaymentData>any())).thenReturn(paymentData);
        when(paymentDataRepository.findAll()).thenReturn(paymentDataList);

        PaymentData paymentData3 = new PaymentData();
        paymentData3.setBookingId(1L);
        paymentData3.setCardNumber(BigInteger.valueOf(1L));
        paymentData3.setCvvNumber(10);
        paymentData3.setExpiryDate(mock(Date.class));
        paymentData3.setId(1L);
        paymentData3.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData3.setTotalPrice(10.0d);
        assertEquals("Booking amount is already paid",
                paymentDataServiceImpl.addPaymentDataByBookingId(paymentData3, 1L));
        verify(bookingDataRepository).findById(Mockito.<Long>any());
        verify(paymentDataRepository).findAll();
        assertEquals(10.0d, paymentData3.getTotalPrice().doubleValue());
    }

    /**
     * Method under test: {@link PaymentDataServiceImpl#addPaymentDataByBookingId(PaymentData, Long)}
     */
    @Test
    void testAddPaymentDataByBookingId4() {
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
        Optional<BookingData> ofResult = Optional.of(bookingData);
        when(bookingDataRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        PaymentData paymentData3 = new PaymentData();
        paymentData3.setBookingId(2L);
        paymentData3.setCardNumber(BigInteger.valueOf(5L));
        paymentData3.setCvvNumber(5);
        paymentData3.setExpiryDate(mock(Date.class));
        paymentData3.setId(2L);
        paymentData3.setPaymentMethod(PaymentMethod.DEBIT);
        paymentData3.setTotalPrice(0.5d);

        ArrayList<PaymentData> paymentDataList = new ArrayList<>();
        paymentDataList.add(paymentData3);
        paymentDataList.add(paymentData2);
        when(paymentDataRepository.save(Mockito.<PaymentData>any())).thenReturn(paymentData);
        when(paymentDataRepository.findAll()).thenReturn(paymentDataList);

        PaymentData paymentData4 = new PaymentData();
        paymentData4.setBookingId(1L);
        paymentData4.setCardNumber(BigInteger.valueOf(1L));
        paymentData4.setCvvNumber(10);
        paymentData4.setExpiryDate(mock(Date.class));
        paymentData4.setId(1L);
        paymentData4.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData4.setTotalPrice(10.0d);
        assertEquals("Booking amount is already paid",
                paymentDataServiceImpl.addPaymentDataByBookingId(paymentData4, 1L));
        verify(bookingDataRepository).findById(Mockito.<Long>any());
        verify(paymentDataRepository).findAll();
        assertEquals(10.0d, paymentData4.getTotalPrice().doubleValue());
    }
}

