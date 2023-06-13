package com.userservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.userservice.entity.BookingData;
import com.userservice.entity.Event;
import com.userservice.repository.BookingDataRepository;
import com.userservice.repository.BookingManagementRepository;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingDataServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingDataServiceImplTest {
    @MockBean
    private BookingDataRepository bookingDataRepository;

    @Autowired
    private BookingDataServiceImpl bookingDataServiceImpl;

    @MockBean
    private BookingManagementRepository bookingManagementRepository;

    /**
     * Method under test: {@link BookingDataServiceImpl#getBookingDataByUserIdandEventId(Long, Long)}
     */
    @Test
    void testGetBookingDataByUserIdandEventId() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setCustomerType("Customer Type");
        bookingData.setEvent(event);
        bookingData.setFoddOptd(true);
        bookingData.setId(1L);
        bookingData.setNoOfBookings(1);
        Optional<BookingData> ofResult = Optional.of(bookingData);
        when(bookingDataRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(bookingManagementRepository.getBookingDataIdsBuUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(1L);
        assertSame(bookingData, bookingDataServiceImpl.getBookingDataByUserIdandEventId(1L, 1L));
        verify(bookingDataRepository).findById(Mockito.<Long>any());
        verify(bookingManagementRepository).getBookingDataIdsBuUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingDataServiceImpl#getBookingDataByUserIdandEventId(Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBookingDataByUserIdandEventId2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.userservice.serviceimpl.BookingDataServiceImpl.getBookingDataByUserIdandEventId(BookingDataServiceImpl.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bookingDataRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        when(bookingManagementRepository.getBookingDataIdsBuUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(1L);
        bookingDataServiceImpl.getBookingDataByUserIdandEventId(1L, 1L);
    }
}

