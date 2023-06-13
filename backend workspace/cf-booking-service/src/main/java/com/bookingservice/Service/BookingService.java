package com.bookingservice.Service;

import java.util.List;

import com.bookingservice.Model.Booking;


public interface BookingService {
	Booking createBooking(Booking booking);
	
	List<Booking> getAllBookings();
	
	Booking getBookingById(long bookingId);
}
