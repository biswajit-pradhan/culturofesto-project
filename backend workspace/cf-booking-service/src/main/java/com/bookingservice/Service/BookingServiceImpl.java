package com.bookingservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.Exception.BookingNotFoundException;
import com.bookingservice.Model.Booking;
import com.bookingservice.Repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		return this.bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(long bookingId) {
		Optional<Booking> bookingObj = this.bookingRepository.findById(bookingId);
		if(bookingObj.isPresent()) {
			return bookingObj.get();
		}
		else {
			throw new BookingNotFoundException("Booking didn't found with Id: " + bookingId);
		}
	}

}
