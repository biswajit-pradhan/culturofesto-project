package com.bookingservice.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.Model.Booking;
import com.bookingservice.Service.BookingService;

@RestController
public class BookingController {
	
	private static final Logger LOG = LogManager.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("api/user/event/booking/bookingdata/{bookingId}")
	public Booking getBookingById(@PathVariable long bookingId) {
		LOG.info("Fetching the booking details by booking id {}", bookingId);
		return this.bookingService.getBookingById(bookingId);
	}
	
	@GetMapping("api/user/event/booking/allBookingdata")
	public ResponseEntity<List<Booking>> getAllBookingData(){
		LOG.info("Fetching all the booking details from the database");
		return ResponseEntity.ok().body(this.bookingService.getAllBookings());
	}
	
	@PostMapping("/api/user/event/booking/bookingdata")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
		LOG.info("Creating a new details, booking info - {}", booking);
		return ResponseEntity.ok().body(this.bookingService.createBooking(booking));
	}
	
	
}
