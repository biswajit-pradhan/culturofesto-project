package com.userservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.userservice.entity.BookingData;
import com.userservice.entity.BookingManagement;
import com.userservice.entity.Event;
import com.userservice.entity.PaymentData;
import com.userservice.entity.User;
import com.userservice.enums.Role;
import com.userservice.repository.BookingManagementRepository;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingManagementServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingManagementServiceImplTest {
    @MockBean
    private BookingManagementRepository bookingManagementRepository;

    @Autowired
    private BookingManagementServiceImpl bookingManagementServiceImpl;

    /**
     * Method under test: {@link BookingManagementServiceImpl#getAllRegestdEventsBuUserId(Long)}
     */
    @Test
    void testGetAllRegestdEventsBuUserId() {
        ArrayList<Long> resultLongList = new ArrayList<>();
        when(bookingManagementRepository.getEventidByUserId(Mockito.<Long>any())).thenReturn(resultLongList);
        List<Long> actualAllRegestdEventsBuUserId = bookingManagementServiceImpl.getAllRegestdEventsBuUserId(1L);
        assertSame(resultLongList, actualAllRegestdEventsBuUserId);
        assertTrue(actualAllRegestdEventsBuUserId.isEmpty());
        verify(bookingManagementRepository).getEventidByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingManagementServiceImpl#cancelEventById(Long, Long)}
     */
    @Test
    void testCancelEventById() {
        when(bookingManagementRepository.getAllBookingManagementDataByUserId(Mockito.<Long>any()))
                .thenReturn(new ArrayList<>());
        when(bookingManagementRepository.saveAll(Mockito.<Iterable<BookingManagement>>any())).thenReturn(new ArrayList<>());
        assertEquals("Registered Event Successfully Canceled", bookingManagementServiceImpl.cancelEventById(1L, 1L));
        verify(bookingManagementRepository).getAllBookingManagementDataByUserId(Mockito.<Long>any());
        verify(bookingManagementRepository).saveAll(Mockito.<Iterable<BookingManagement>>any());
    }

    /**
     * Method under test: {@link BookingManagementServiceImpl#cancelEventById(Long, Long)}
     */
    @Test
    void testCancelEventById2() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Canceling event with ID {} for user with ID: {}");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setCustomerType("Canceling event with ID {} for user with ID: {}");
        bookingData.setEvent(event);
        bookingData.setFoddOptd(true);
        bookingData.setId(1L);
        bookingData.setNoOfBookings(1);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Canceling event with ID {} for user with ID: {}");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        Event event3 = new Event();
        event3.setBreakfastPrice(10.0d);
        event3.setDeleteStatus(true);
        event3.setDinnerPrice(10.0d);
        event3.setEventCapacity(1L);
        event3.setEventCloseTime(mock(Time.class));
        event3.setEventDate(mock(Date.class));
        event3.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event3.setEventName("Canceling event with ID {} for user with ID: {}");
        event3.setEventStartTime(mock(Time.class));
        event3.setId(1L);
        event3.setLunchPrice(10.0d);
        event3.setRegistrationCloseDate(mock(Date.class));
        event3.setRegistrationFee(10.0d);
        event3.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setCustomerType("Canceling event with ID {} for user with ID: {}");
        bookingData2.setEvent(event3);
        bookingData2.setFoddOptd(true);
        bookingData2.setId(1L);
        bookingData2.setNoOfBookings(1);

        PaymentData paymentData = new PaymentData();
        paymentData.setBookingData(bookingData2);
        paymentData.setCardNumber(1L);
        paymentData.setCvvNumber(10);
        paymentData.setExpDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setOtp(1);
        paymentData.setPaymentMethod("Canceling event with ID {} for user with ID: {}");
        paymentData.setTicketPrice(1);

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingData(bookingData);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEvent(event2);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentData(paymentData);
        bookingManagement.setTicketNo("Canceling event with ID {} for user with ID: {}");
        bookingManagement.setUser(user);

        ArrayList<BookingManagement> bookingManagementList = new ArrayList<>();
        bookingManagementList.add(bookingManagement);
        when(bookingManagementRepository.getAllBookingManagementDataByUserId(Mockito.<Long>any()))
                .thenReturn(bookingManagementList);
        when(bookingManagementRepository.saveAll(Mockito.<Iterable<BookingManagement>>any()))
                .thenReturn(new ArrayList<>());
        assertEquals("Registered Event Successfully Canceled", bookingManagementServiceImpl.cancelEventById(1L, 1L));
        verify(bookingManagementRepository).getAllBookingManagementDataByUserId(Mockito.<Long>any());
        verify(bookingManagementRepository).saveAll(Mockito.<Iterable<BookingManagement>>any());
    }

    /**
     * Method under test: {@link BookingManagementServiceImpl#cancelEventById(Long, Long)}
     */
    @Test
    void testCancelEventById3() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Canceling event with ID {} for user with ID: {}");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setCustomerType("Canceling event with ID {} for user with ID: {}");
        bookingData.setEvent(event);
        bookingData.setFoddOptd(true);
        bookingData.setId(1L);
        bookingData.setNoOfBookings(1);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Canceling event with ID {} for user with ID: {}");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        Event event3 = new Event();
        event3.setBreakfastPrice(10.0d);
        event3.setDeleteStatus(true);
        event3.setDinnerPrice(10.0d);
        event3.setEventCapacity(1L);
        event3.setEventCloseTime(mock(Time.class));
        event3.setEventDate(mock(Date.class));
        event3.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event3.setEventName("Canceling event with ID {} for user with ID: {}");
        event3.setEventStartTime(mock(Time.class));
        event3.setId(1L);
        event3.setLunchPrice(10.0d);
        event3.setRegistrationCloseDate(mock(Date.class));
        event3.setRegistrationFee(10.0d);
        event3.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setCustomerType("Canceling event with ID {} for user with ID: {}");
        bookingData2.setEvent(event3);
        bookingData2.setFoddOptd(true);
        bookingData2.setId(1L);
        bookingData2.setNoOfBookings(1);

        PaymentData paymentData = new PaymentData();
        paymentData.setBookingData(bookingData2);
        paymentData.setCardNumber(1L);
        paymentData.setCvvNumber(10);
        paymentData.setExpDate(mock(Date.class));
        paymentData.setId(1L);
        paymentData.setOtp(1);
        paymentData.setPaymentMethod("Canceling event with ID {} for user with ID: {}");
        paymentData.setTicketPrice(1);

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingData(bookingData);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEvent(event2);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentData(paymentData);
        bookingManagement.setTicketNo("Canceling event with ID {} for user with ID: {}");
        bookingManagement.setUser(user);

        Event event4 = new Event();
        event4.setBreakfastPrice(0.5d);
        event4.setDeleteStatus(false);
        event4.setDinnerPrice(0.5d);
        event4.setEventCapacity(1L);
        event4.setEventCloseTime(mock(Time.class));
        event4.setEventDate(mock(Date.class));
        event4.setEventImage(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});
        event4.setEventName("Event with ID {} canceled for user with ID: {}");
        event4.setEventStartTime(mock(Time.class));
        event4.setId(2L);
        event4.setLunchPrice(0.5d);
        event4.setRegistrationCloseDate(mock(Date.class));
        event4.setRegistrationFee(0.5d);
        event4.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData3 = new BookingData();
        bookingData3.setBookingDate(mock(Date.class));
        bookingData3.setCustomerType("Event with ID {} canceled for user with ID: {}");
        bookingData3.setEvent(event4);
        bookingData3.setFoddOptd(false);
        bookingData3.setId(2L);
        bookingData3.setNoOfBookings(1);

        Event event5 = new Event();
        event5.setBreakfastPrice(0.5d);
        event5.setDeleteStatus(false);
        event5.setDinnerPrice(0.5d);
        event5.setEventCapacity(1L);
        event5.setEventCloseTime(mock(Time.class));
        event5.setEventDate(mock(Date.class));
        event5.setEventImage(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});
        event5.setEventName("Event with ID {} canceled for user with ID: {}");
        event5.setEventStartTime(mock(Time.class));
        event5.setId(2L);
        event5.setLunchPrice(0.5d);
        event5.setRegistrationCloseDate(mock(Date.class));
        event5.setRegistrationFee(0.5d);
        event5.setRegistrationOpenDate(mock(Date.class));

        Event event6 = new Event();
        event6.setBreakfastPrice(0.5d);
        event6.setDeleteStatus(false);
        event6.setDinnerPrice(0.5d);
        event6.setEventCapacity(1L);
        event6.setEventCloseTime(mock(Time.class));
        event6.setEventDate(mock(Date.class));
        event6.setEventImage(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});
        event6.setEventName("Event with ID {} canceled for user with ID: {}");
        event6.setEventStartTime(mock(Time.class));
        event6.setId(2L);
        event6.setLunchPrice(0.5d);
        event6.setRegistrationCloseDate(mock(Date.class));
        event6.setRegistrationFee(0.5d);
        event6.setRegistrationOpenDate(mock(Date.class));

        BookingData bookingData4 = new BookingData();
        bookingData4.setBookingDate(mock(Date.class));
        bookingData4.setCustomerType("Event with ID {} canceled for user with ID: {}");
        bookingData4.setEvent(event6);
        bookingData4.setFoddOptd(false);
        bookingData4.setId(2L);
        bookingData4.setNoOfBookings(1);

        PaymentData paymentData2 = new PaymentData();
        paymentData2.setBookingData(bookingData4);
        paymentData2.setCardNumber(1L);
        paymentData2.setCvvNumber(6);
        paymentData2.setExpDate(mock(Date.class));
        paymentData2.setId(2L);
        paymentData2.setOtp(1);
        paymentData2.setPaymentMethod("Event with ID {} canceled for user with ID: {}");
        paymentData2.setTicketPrice(1);

        User user2 = new User();
        user2.setId(2L);
        user2.setRole(Role.ADMIN);
        user2.setUserEmail("john.smith@example.org");
        user2.setUserName("Canceling event with ID {} for user with ID: {}");
        user2.setUserPassword("Canceling event with ID {} for user with ID: {}");

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingData(bookingData3);
        bookingManagement2.setCancelStatus(false);
        bookingManagement2.setEvent(event5);
        bookingManagement2.setId(2L);
        bookingManagement2.setPaymentData(paymentData2);
        bookingManagement2.setTicketNo("Event with ID {} canceled for user with ID: {}");
        bookingManagement2.setUser(user2);

        ArrayList<BookingManagement> bookingManagementList = new ArrayList<>();
        bookingManagementList.add(bookingManagement2);
        bookingManagementList.add(bookingManagement);
        when(bookingManagementRepository.getAllBookingManagementDataByUserId(Mockito.<Long>any()))
                .thenReturn(bookingManagementList);
        when(bookingManagementRepository.saveAll(Mockito.<Iterable<BookingManagement>>any()))
                .thenReturn(new ArrayList<>());
        assertEquals("Registered Event Successfully Canceled", bookingManagementServiceImpl.cancelEventById(1L, 1L));
        verify(bookingManagementRepository).getAllBookingManagementDataByUserId(Mockito.<Long>any());
        verify(bookingManagementRepository).saveAll(Mockito.<Iterable<BookingManagement>>any());
    }
}

