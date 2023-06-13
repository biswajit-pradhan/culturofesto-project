package com.bookingservice.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bookingservice.Exception.BookingNotFoundException;
import com.bookingservice.Model.Booking;
import com.bookingservice.Repository.BookingRepository;
import com.bookingservice.enums.CustomerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingServiceImplTest {
    @MockBean
    private BookingRepository bookingRepository;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    /**
     * Method under test: {@link BookingServiceImpl#createBooking(Booking)}
     */
    @Test
    void testCreateBooking() {
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setBreakFastOpted(true);
        booking.setCustomerType(CustomerType.ADULT);
        booking.setDinnerOpted(true);
        booking.setEventId(1L);
        booking.setFoodOpted(true);
        booking.setLunchOpted(true);
        booking.setNumberOfBooking(1L);
        when(bookingRepository.save(Mockito.<Booking>any())).thenReturn(booking);

        Booking booking2 = new Booking();
        booking2.setBookingId(1L);
        booking2.setBreakFastOpted(true);
        booking2.setCustomerType(CustomerType.ADULT);
        booking2.setDinnerOpted(true);
        booking2.setEventId(1L);
        booking2.setFoodOpted(true);
        booking2.setLunchOpted(true);
        booking2.setNumberOfBooking(1L);
        assertSame(booking, bookingServiceImpl.createBooking(booking2));
        verify(bookingRepository).save(Mockito.<Booking>any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#createBooking(Booking)}
     */
    @Test
    void testCreateBooking2() {
        when(bookingRepository.save(Mockito.<Booking>any())).thenThrow(new BookingNotFoundException("An error occurred"));

        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setBreakFastOpted(true);
        booking.setCustomerType(CustomerType.ADULT);
        booking.setDinnerOpted(true);
        booking.setEventId(1L);
        booking.setFoodOpted(true);
        booking.setLunchOpted(true);
        booking.setNumberOfBooking(1L);
        assertThrows(BookingNotFoundException.class, () -> bookingServiceImpl.createBooking(booking));
        verify(bookingRepository).save(Mockito.<Booking>any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getAllBookings()}
     */
    @Test
    void testGetAllBookings() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        when(bookingRepository.findAll()).thenReturn(bookingList);
        List<Booking> actualAllBookings = bookingServiceImpl.getAllBookings();
        assertSame(bookingList, actualAllBookings);
        assertTrue(actualAllBookings.isEmpty());
        verify(bookingRepository).findAll();
    }

    /**
     * Method under test: {@link BookingServiceImpl#getAllBookings()}
     */
    @Test
    void testGetAllBookings2() {
        when(bookingRepository.findAll()).thenThrow(new BookingNotFoundException("An error occurred"));
        assertThrows(BookingNotFoundException.class, () -> bookingServiceImpl.getAllBookings());
        verify(bookingRepository).findAll();
    }

    /**
     * Method under test: {@link BookingServiceImpl#getBookingById(long)}
     */
    @Test
    void testGetBookingById() {
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setBreakFastOpted(true);
        booking.setCustomerType(CustomerType.ADULT);
        booking.setDinnerOpted(true);
        booking.setEventId(1L);
        booking.setFoodOpted(true);
        booking.setLunchOpted(true);
        booking.setNumberOfBooking(1L);
        Optional<Booking> ofResult = Optional.of(booking);
        when(bookingRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(booking, bookingServiceImpl.getBookingById(1L));
        verify(bookingRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getBookingById(long)}
     */
    @Test
    void testGetBookingById2() {
        when(bookingRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        assertThrows(BookingNotFoundException.class, () -> bookingServiceImpl.getBookingById(1L));
        verify(bookingRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getBookingById(long)}
     */
    @Test
    void testGetBookingById3() {
        when(bookingRepository.findById(Mockito.<Long>any()))
                .thenThrow(new BookingNotFoundException("An error occurred"));
        assertThrows(BookingNotFoundException.class, () -> bookingServiceImpl.getBookingById(1L));
        verify(bookingRepository).findById(Mockito.<Long>any());
    }
}

